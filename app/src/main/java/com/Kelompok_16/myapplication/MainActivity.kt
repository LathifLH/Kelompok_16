package com.Kelompok_16.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.avief_reja.myapplication.databinding.ActivityMainBinding
import com.avief_reja.myapplication.ui.SharedViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    /* for view binding */
    private lateinit var binding: ActivityMainBinding
    private val viewModel: SharedViewModel by viewModels()
    private var currentLocation: Location? = null

    /* for location */
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        setupNavigation()
        getMyLocation()
    }

    /* for setup navigation bottom */
    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment

        binding.navView.background = null
        binding.navView.menu.getItem(1).isEnabled = false
        binding.navView.setupWithNavController(navHostFragment.navController)

        binding.fabLocation.setOnClickListener {
            currentLocation?.let {
                val gmmIntentUri = Uri.parse("geo:${it.latitude},${it.longitude}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        }
    }

    /* launcher untuk meminta permission
    * jika permission diberikan maka dapatkan lokasi
    * jika tidak maka tampilkan toast
     */
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                getMyLocation()
            } else {
                viewModel.setLocation(-7.05800729, 109.426030)
                Toast.makeText(this, getString(R.string.cant_get_permission), Toast.LENGTH_SHORT)
                    .show()
            }
        }

    /* fungsi untuk mendapatkan lokasi
    * pertama cek apakah permission sudah diberikan
    * jika sudah maka dapatkan lokasi
    * jika belum maka minta permission
    *  */
    private fun getMyLocation() {
        if (ContextCompat.checkSelfPermission(
                this.applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationClient.lastLocation.addOnSuccessListener {
                it?.let {
                    currentLocation = it
                    viewModel.setLocation(it.latitude, it.longitude)
                }
            }
        } else {
            viewModel.setLocation(-7.05800729, 109.426030)
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
}

package com.Kelompok_16.myapplication.ui.detail

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.avief_reja.myapplication.R
import com.avief_reja.myapplication.databinding.ActivityDetailBinding
import com.avief_reja.myapplication.model.Food
import com.avief_reja.myapplication.model.TouristAttraction
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TOURIST_ATTRACTION = "extra_tourist_attraction"
        const val EXTRA_FOOD = "extra_food"
        const val EXTRA_LATITUDE = "extra_latitude"
        const val EXTRA_LONGITUDE = "extra_longitude"
    }

    private lateinit var binding: ActivityDetailBinding

    private var touristAttraction: TouristAttraction? = null
    private var food: Food? = null
    private var latitude: Double? = null
    private var longitude: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        * Ambil data dari intent yang dikirimkan dari HomeFragment/FoodFragment
         */
        touristAttraction = intent.getParcelableExtra(EXTRA_TOURIST_ATTRACTION)
        food = intent.getParcelableExtra(EXTRA_FOOD)
        latitude = intent.getDoubleExtra(EXTRA_LATITUDE, 0.0)
        longitude = intent.getDoubleExtra(EXTRA_LONGITUDE, 0.0)

        touristAttraction?.let { setDataTouristAttraction(it) }
        food?.let { setDataFood(it) }
        initListener()

    }

    /* Mengatur action */
    private fun initListener() {
        binding.apply {
            cvBack.setOnClickListener { finish() }
        }
    }

    /* Mengatur data untuk detail food */
    private fun setDataFood(it: Food) {
        binding.apply {
            ivDetail.load(it.imageUrl)
            tvDetailName.text = it.name
            tvDetailLocation.text = it.locationName
            tvDetailDesc.text = it.description
            hsvDetail.visibility = View.GONE
            llShowLocation.visibility = View.GONE
            isFavoriteEnable(it.isFavorite)
        }
    }

    /* Mengatur data untuk detail tourist attraction */
    private fun setDataTouristAttraction(data: TouristAttraction) {
        binding.apply {
            ivDetail.load(data.imageUrl)
            tvDetailName.text = data.name
            tvDetailLocation.text = data.locationName
            tvDetailDesc.text = data.description
            isFavoriteEnable(data.isFavorite)

            cardRating.apply {
                tvCardDesc.text = data.rating.toString()
                tvCardTitle.text = getString(R.string.nilai)
                ivCardDetail.load(R.drawable.ic_star)
            }

            cardDistance.apply {
                tvCardDesc.text = calculateDistance(
                    latitude ?: 0.0,
                    longitude ?: 0.0,
                    data.latitude,
                    data.longitude,
                )
                tvCardTitle.text = getString(R.string.jarak)
                ivCardDetail.load(R.drawable.ic_distance)
            }

            cardTotalRestaurant.apply {
                tvCardTitle.text = getString(R.string.tempat_makan)
                tvCardDesc.text = 10.toString()
                ivCardDetail.load(R.drawable.ic_restaurant)
            }

            btnShowLocation.setOnClickListener {
                openGoogleMaps(
                    data.latitude.toString(),
                    data.longitude.toString(),
                    data.name,
                    "15"
                )
            }
        }
    }

    /* Mmebuka google map */
    private fun openGoogleMaps(
        latitude: String,
        longitude: String,
        name: String,
        zoom: String,
    ) {
        val uri =
            Uri.parse("geo:$latitude,$longitude?z=$zoom&q=$latitude,$longitude ($name)")
        val mapsIntent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(mapsIntent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this,
                getString(R.string.google_maps_is_not_available), Toast.LENGTH_SHORT
            ).show()
        }
    }

    /* Mengatur icon favorite */
    private fun isFavoriteEnable(state: Boolean) {
        if (state) {
            binding.ivFavorite.load(R.drawable.ic_favorite)
        } else {
            binding.ivFavorite.load(R.drawable.ic_not_favorite)
        }
    }

    /*
    * Menghitung jarak antara dua titik koordinat
    * Menggunakan Haversine Formula
    * https://en.wikipedia.org/wiki/Haversine_formula
    *
    * Rumus Haversine Formula
    * a = sin²(Δφ/2) + cos φ1 * cos φ2 * sin²(Δλ/2)
    * c = 2 * atan2(√a, √(1−a))
    * d = R * c
    *
    * Dapat dari chatGPT
    *
     */
    private fun calculateDistance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): String {
        val earthRadius = 6371.0 // Radius bumi dalam kilometer

        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)

        val a = sin(dLat / 2) * sin(dLat / 2) +
                cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) *
                sin(dLon / 2) * sin(dLon / 2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        val distance = earthRadius * c

        return if (distance < 1) {
            "${(distance * 1000).toInt()} m" // Jarak kurang dari 1 kilometer, satuan dalam meter
        } else {
            "${distance.toInt()} km" // Jarak lebih dari atau sama dengan 1 kilometer, satuan dalam kilometer
        }
    }
}

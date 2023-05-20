package com.Kelompok_16.myapplication.ui

import android.content.Context
import android.location.Address
import android.location.Geocoder
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avief_reja.myapplication.data.FoodDataSource
import com.avief_reja.myapplication.data.TouristsDataSource
import com.avief_reja.myapplication.model.Food
import com.avief_reja.myapplication.model.TouristAttraction
import com.google.android.gms.maps.model.LatLng
import java.util.Locale

class SharedViewModel : ViewModel() {
    /**
     * This is a LiveData object. It will be used to communicate between fragments and activity.
     */
    private val _location = MutableLiveData<LatLng>()
    val location get() = _location

    private val _touristAttractionData = MutableLiveData<List<TouristAttraction>>()
    val touristAttractionData get() = _touristAttractionData

    private val _foodData = MutableLiveData<List<Food>>()
    val foodData get() = _foodData

    /**
     * This is a function to initialize the data.
     */
    init {
        _touristAttractionData.value = TouristsDataSource.createTouristAttractionData()
        _foodData.value = FoodDataSource.createFoodData()
    }

    /**
     * This is a function to set the location.
     */
    fun setLocation(latitude: Double, longitude: Double) {
        _location.value = LatLng(latitude, longitude)
    }

    /**
     * This is a function to set the location.
     */
    fun filterTouristAttraction(category: String) {
        _touristAttractionData.value =
            TouristsDataSource.createTouristAttractionData().filter { it.category == category }
    }

    /**
     * This is a function to set the Food.
     */
    fun filterFood(category: String) {
        _foodData.value =
            FoodDataSource.createFoodData().filter { it.category == category }
    }

    /**
     * This is a function to get the location name from latitude and longitude.
     */
    fun getStringLocation(context: Context, location: LatLng): String {
        var stringLocation: String
        location.let {
            val currentLatLong = LatLng(it.latitude, it.longitude)
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses: MutableList<Address>? = geocoder.getFromLocation(
                currentLatLong.latitude,
                currentLatLong.longitude,
                1
            )
            /* get regency and province */
            val regency = addresses?.get(0)?.subAdminArea ?: "Pemalang"
            val province = addresses?.get(0)?.adminArea ?: "Jawa Tengah"

            stringLocation = "${regency.substringAfter("Kabupaten")} $province"
        }

        return stringLocation
    }
}

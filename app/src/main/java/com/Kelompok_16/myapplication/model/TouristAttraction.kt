package com.Kelompok_16.myapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TouristAttraction(
    val name: String,
    val locationName: String,
    val description: String,
    val imageUrl: String,
    val rating: Double,
    val category: String,
    val latitude: Double,
    val longitude: Double,
    val isFavorite: Boolean = false,
) : Parcelable


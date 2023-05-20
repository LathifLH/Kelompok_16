package com.Kelompok_16.myapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    val name: String,
    val locationName: String,
    val description: String,
    val imageUrl: String,
    val rating: Double,
    val category: String,
    val isFavorite: Boolean = false,
) : Parcelable

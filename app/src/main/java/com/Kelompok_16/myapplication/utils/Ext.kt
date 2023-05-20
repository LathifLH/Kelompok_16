package com.Kelompok_16.myapplication.utils

import android.content.Context
import android.util.TypedValue

fun Context.resolveAttributeColor(attr: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attr, typedValue, true)
    return typedValue.data
}

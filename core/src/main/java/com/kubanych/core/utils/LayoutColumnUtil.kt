package com.kubanych.core.utils

import android.content.Context
import android.util.DisplayMetrics

/**
 * Calculate adaptive span count
 *
 * based on screen pixels
 */
object LayoutColumnUtil {
    fun calculateNoOfColumns(
        context: Context,
        columnWidthDp: Float,
    ): Int {
        val displayMetrics: DisplayMetrics = context.resources.displayMetrics
        val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
        return (screenWidthDp / columnWidthDp + 0.5).toInt()
    }
}
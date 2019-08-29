package com.example.twitterpresidents.util

import android.content.res.Resources
import kotlin.math.roundToInt

object Utils {
    fun convertDpToPixel(dp: Float): Int {
        val metrics = Resources.getSystem().displayMetrics
        val px = dp * (metrics.densityDpi / 160f)
        return px.roundToInt()
    }
}
package com.example.catcraft.customviews

import android.content.Context
import android.graphics.Typeface

object FontCache {
    private val fontCache: HashMap<String, Typeface?> = HashMap()

    fun getFont(context: Context, fontName: String): Typeface? {

        var typeface = fontCache[fontName]
        if (typeface == null) {
            typeface = try {
                Typeface.createFromAsset(context.assets, fontName)
            } catch (e: Exception) {

                return null
            }
            fontCache[fontName] = typeface
        }
        return typeface
    }
}
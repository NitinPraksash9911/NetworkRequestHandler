package com.example.catcraft.customviews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.catcraft.R

class AppTextView : AppCompatTextView {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs!!, 0)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initResources(context, attrs, defStyleAttr)
    }

    private fun initResources(context: Context?, attrs: AttributeSet?, defStyleAttr: Int?) {

        val typedArray = context!!.obtainStyledAttributes(attrs, R.styleable.customView, 0, 0)
        try {
            var fontIndex = typedArray.getInt(R.styleable.customView_textStyle, 0)
            setTextFont(context, fontIndex)
        } finally {
            typedArray.recycle()
        }
    }

    private fun setTextFont(context: Context, fontIndex: Int) {
        var typeface: Typeface?
        when (fontIndex) {
            Font.BOLD -> typeface = FontCache.getFont(context, Font.BOLD_FONT)
            Font.LIGHT -> typeface = FontCache.getFont(context, Font.LIGHT_FONT)
            Font.SEMI_BOLD -> typeface = FontCache.getFont(context, Font.SEMI_BOLD_FONT)
            Font.REGULAR -> typeface = FontCache.getFont(context, Font.REGULAR_FONT)
            Font.EXTRA_BOLD -> typeface = FontCache.getFont(context, Font.EXTRA_BOLD_FONT)
            Font.ITALIC -> {
                typeface = FontCache.getFont(context, Font.REGULAR_FONT)
                typeface = Typeface.create(typeface, Typeface.ITALIC)
            }
            else -> typeface = FontCache.getFont(context, Font.REGULAR_FONT)
        }
        setTypeface(typeface)
    }

}
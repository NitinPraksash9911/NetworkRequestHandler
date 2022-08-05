package com.example.catcraft.utils

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.catcraft.R
import com.google.android.material.snackbar.Snackbar

fun ImageView.loadImageWithUrl(imgUrl: String?) {
    val brokenImage = R.drawable.ic_broken_image
    val requestOption = RequestOptions()
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_broken_image)
        .centerInside()

    Glide.with(this.context)
        .load(imgUrl ?: brokenImage)
        .transition(DrawableTransitionOptions.withCrossFade())
        .centerCrop()
        .apply(requestOption)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .listener(MyImageRequestListener(object : MyImageRequestListener.Callback {
            override fun onFailure(message: String?) {
//                Toast.makeText(this@loadImage.context, message, Toast.LENGTH_LONG).show()
            }

            override fun onSuccess(dataSource: String, resource: Drawable) {
//                Toast.makeText(this@loadImage.context, dataSource, Toast.LENGTH_LONG).show()
            }

        }))
        .into(this)
}

fun String.snack(color: Int, view: View, duration: Int = Snackbar.LENGTH_LONG) {
    val snackbar = Snackbar.make(view, this, duration)
    snackbar.view.setBackgroundColor(color)
    snackbar.setTextColor(Color.WHITE)
    snackbar.show()
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}


//1-> Custom toast
//2-> error desr
//3 Image could be defualt one and from backand
// typ of error from backend

package com.yasintanriverdi.commons.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

private val imageRequestOptions by lazy {
    RequestOptions()
        .centerCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
}

fun ImageView.loadImage(imageUrl: String?) {
    Glide.with(context)
        .load("https://image.tmdb.org/t/p/w500/$imageUrl")
        .apply(imageRequestOptions)
        .into(this)
}

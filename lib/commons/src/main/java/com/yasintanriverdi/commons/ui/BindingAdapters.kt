package com.yasintanriverdi.commons.ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.yasintanriverdi.commons.extensions.loadImage

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setUrl(imageView: ImageView, imageUrl: String?) {
        imageView.loadImage(imageUrl)
    }

    @JvmStatic
    @BindingAdapter("visible")
    fun setVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }
}
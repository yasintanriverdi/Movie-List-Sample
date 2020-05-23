package com.yasintanriverdi.commons.extensions

import android.view.View

fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.show() {
    setVisibility(visible = true)
}

fun View.hide() {
    setVisibility(visible = false)
}
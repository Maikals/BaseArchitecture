package com.maikals.basearchitecture.extensions

import android.widget.ImageView
import com.maikals.basearchitecture.glideModules.GlideApp

fun ImageView.loadFromUrl(url: String) {
    GlideApp.with(this)
        .load(url)
        .into(this)
}
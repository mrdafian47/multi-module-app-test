package com.dafian.android.common.util.extension

import android.os.Build
import android.support.annotation.DrawableRes
import android.support.graphics.drawable.VectorDrawableCompat
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.goneIf(condition: Boolean) {
    if (condition) {
        gone()
    } else {
        visible()
    }
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun ImageView.loadUrl(url: String?) {
    url?.let {
        Glide.with(this)
            .load(url)
    }
}

fun ImageView.setDrawableVectorCompat(@DrawableRes drawableId: Int?) {
    if (drawableId == null) return
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        this.setImageDrawable(
            VectorDrawableCompat.create(this.context.resources, drawableId, this.context.theme)
        )
    } else {
        this.setImageResource(drawableId)
    }
}
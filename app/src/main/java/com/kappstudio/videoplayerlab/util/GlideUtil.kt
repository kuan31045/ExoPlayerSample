package com.kappstudio.videoplayerlab.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kappstudio.videoplayerlab.R

/**
 * Using Glide set the image from url to ImageView
 */
fun setImage(iv: ImageView, imgUrl: String) {
    Glide.with(iv.context)
        .load(imgUrl)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.image_video_loading)
                .error(R.drawable.image_video_loading)
        )
        .into(iv)
}
package com.kappstudio.videoplayerlab.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val name: String,
    val cover: String,
    val desc: String,
    val isSeries: Boolean,
    val videoList: List<VideoItem>,
) : Parcelable
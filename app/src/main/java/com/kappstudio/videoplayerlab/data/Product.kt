package com.kappstudio.videoplayerlab.data

data class Product(
    val id: String,
    val name: String,
    val cover: String,
    val desc: String,
    val type:String,
    val videoList: List<VideoItem>,
)
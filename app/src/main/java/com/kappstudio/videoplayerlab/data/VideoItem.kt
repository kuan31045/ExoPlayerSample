package com.kappstudio.videoplayerlab.data

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class VideoItem(
    @PrimaryKey val id: String,
    val title: String,
    val cover: String,
    val video: String,
    @ColumnInfo(name = "last_watched_seconds")
    var LastWatchedSeconds: Long? = null,
)
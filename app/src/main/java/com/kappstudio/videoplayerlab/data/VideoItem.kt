package com.kappstudio.videoplayerlab.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoItem(
    @PrimaryKey val id: String,
    val productId:String,
    val title: String="",
    val cover: String="",
    val video: String,
    val desc: String="",
    @ColumnInfo(name = "last_watched_seconds")
    var LastWatchedSeconds: Long? = null,
    @ColumnInfo(name = "saved_time")
    var savedTime: Long? = null,
) : Parcelable
package com.kappstudio.videoplayerlab.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class History(

    @PrimaryKey val id: String, //video id

    val productId:String,

    @ColumnInfo(name = "last_watched_seconds")
    var LastWatchedSeconds: Long? = null,

    @ColumnInfo(name = "saved_time")
    var savedTime: Long? = null,

) : Parcelable
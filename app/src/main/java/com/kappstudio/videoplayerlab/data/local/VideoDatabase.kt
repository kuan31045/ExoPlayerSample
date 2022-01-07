package com.kappstudio.videoplayerlab.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kappstudio.videoplayerlab.data.VideoItem

@Database(
    entities = [VideoItem::class],
    version = 1
)
abstract class VideoDatabase : RoomDatabase() {

    abstract val dao: VideoDao
}
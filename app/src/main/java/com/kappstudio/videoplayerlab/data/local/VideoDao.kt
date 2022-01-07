package com.kappstudio.videoplayerlab.data.local

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kappstudio.videoplayerlab.data.History

interface VideoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(history: History)

    @Delete
    suspend fun deleteHistory(history: History)

    @Query("SELECT * FROM history WHERE id = :id")
    suspend fun getHistoryById(id: String): History?

    @Query("SELECT * FROM history")
    fun getHistories(): LiveData<List<History>>
}
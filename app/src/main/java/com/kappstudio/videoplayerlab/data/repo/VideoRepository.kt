package com.kappstudio.videoplayerlab.data.repo

import androidx.lifecycle.LiveData
import com.kappstudio.videoplayerlab.data.History

interface VideoRepository {

    suspend fun insertHistory(history: History)

    suspend fun deleteHistory(history: History)

    suspend fun getHistoryById(id: String): History?

    fun getHistories(): LiveData<List<History>>
}
package com.kappstudio.videoplayerlab.data.repo

import androidx.lifecycle.LiveData
import com.kappstudio.videoplayerlab.data.History
import com.kappstudio.videoplayerlab.data.local.VideoDao

class VideoRepositoryImpl(
    private val dao: VideoDao
) : VideoRepository {
    override suspend fun insertHistory(history: History) {
        return dao.insertHistory(history)
    }

    override suspend fun deleteHistory(history: History) {
        return dao.deleteHistory(history)
    }

    override suspend fun getHistoryById(id: String): History? {
        return dao.getHistoryById(id)
    }

    override fun getHistories(): LiveData<List<History>> {
        return dao.getHistories()
    }


}
package com.kappstudio.videoplayerlab.di

import android.app.Application
import androidx.room.Room
import com.kappstudio.videoplayerlab.data.local.VideoDatabase
import com.kappstudio.videoplayerlab.data.repo.VideoRepository
import com.kappstudio.videoplayerlab.data.repo.VideoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideVideoDatabase(app: Application): VideoDatabase {
        return Room.databaseBuilder(
            app,
            VideoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideVideoRepository(db: VideoDatabase): VideoRepository {
        return VideoRepositoryImpl(db.dao)
    }
}
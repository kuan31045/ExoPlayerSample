package com.kappstudio.videoplayerlab

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlin.properties.Delegates

@HiltAndroidApp
class VideoApp : Application() {
    companion object {
        var application: Application by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}
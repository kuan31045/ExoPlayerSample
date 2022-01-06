package com.kappstudio.videoplayerlab

import android.app.Application
import kotlin.properties.Delegates

class VideoApp : Application() {
    companion object {
        var application: Application by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}
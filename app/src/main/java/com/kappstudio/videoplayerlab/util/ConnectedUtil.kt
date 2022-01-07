package com.kappstudio.videoplayerlab.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.kappstudio.videoplayerlab.VideoApp.Companion.application

//Check if the network is connected.
fun isInternetConnected(): Boolean {
    val cm = application
        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
}
package com.kappstudio.videoplayerlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kappstudio.videoplayerlab.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}
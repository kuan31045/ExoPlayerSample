package com.kappstudio.videoplayerlab.ui.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.kappstudio.videoplayerlab.data.Product
import com.kappstudio.videoplayerlab.data.VideoItem

class PlayerViewModel(currentProduct: Product, episode: Int) : ViewModel() {

    private val _product = MutableLiveData<Product>(currentProduct)
    val product: LiveData<Product>
        get() = _product

    //Creating mediaSource
    fun buildMediaSource( ): MutableList<MediaSource> {
        val mediaList:MutableList<MediaSource> = mutableListOf()

        // Create a data source factory.
        val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()

        // Create a progressive media source pointing to a stream uri.
        product.value?.videoList?.forEach {
            mediaList.add(
                ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(MediaItem.fromUri(it.video)) )
        }


        return mediaList
    }
}
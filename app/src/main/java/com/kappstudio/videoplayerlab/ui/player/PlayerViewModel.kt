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

class PlayerViewModel(currentProduct: Product, episode: Int) : ViewModel() {

    private val _product = MutableLiveData<Product>(currentProduct)
    val product: LiveData<Product>
        get() = _product

    private val _currentEpisode = MutableLiveData<Int>(episode)
    val currentEpisode: LiveData<Int>
        get() = _currentEpisode

    private val _playbackPosition = MutableLiveData<Long>(0L)
    val playbackPosition: LiveData<Long>
        get() = _playbackPosition

    fun setCurrentEpisode(episode: Int) {
        _currentEpisode.value = episode
    }
    fun setPlaybackPosition(position: Long) {
        _playbackPosition.value = position
    }

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
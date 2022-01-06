package com.kappstudio.videoplayerlab.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kappstudio.videoplayerlab.data.Product

class DetailViewModel(currentProduct: Product) : ViewModel() {

    private val _product = MutableLiveData<Product>(currentProduct)
    val product: LiveData<Product>
        get() = _product

    private val _navToPlayer = MutableLiveData<Int?>()
    val navToPlayer: LiveData<Int?>
        get() = _navToPlayer

    fun navToPlayer(episode: Int) {
        _navToPlayer.value = episode
    }

    fun onNavToPlayer() {
        _navToPlayer.value = null
    }
}
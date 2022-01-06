package com.kappstudio.videoplayerlab.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kappstudio.videoplayerlab.data.Product

class DetailViewModel(currentProduct: Product) : ViewModel() {

    private val _product = MutableLiveData<Product>(currentProduct)
    val product: LiveData<Product>
        get() = _product
}
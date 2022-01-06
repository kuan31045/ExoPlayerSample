package com.kappstudio.videoplayerlab.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kappstudio.videoplayerlab.data.Product
import com.kappstudio.videoplayerlab.data.SampleData

class HomeViewModel:ViewModel() {

    private val _myList = MutableLiveData<List<Product>>()
    val myList: LiveData<List<Product>>
        get() = _myList

    init {
        getMyList()
    }

    private fun getMyList() {
        _myList.value = SampleData.myList
    }
}
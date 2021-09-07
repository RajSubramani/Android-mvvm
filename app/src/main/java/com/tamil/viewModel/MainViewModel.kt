package com.tamil.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    init {
        Log.i("MainViewModel", "MainViewModel created!")
    }

    var displayName = MutableLiveData<MutableList<String>>().apply {
        value =
            mutableListOf("Pandi", "Uma", "Tamil", "Viyan")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("MainViewModel", "MainViewModel destroyed!")
    }

}
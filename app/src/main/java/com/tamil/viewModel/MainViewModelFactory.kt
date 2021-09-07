package com.tamil.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val name: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModelWithConstructor::class.java)) {
            return MainViewModelWithConstructor(name) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
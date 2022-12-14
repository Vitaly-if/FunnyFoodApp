package com.example.funnyfood.sl.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFactory<T : ViewModel>(private val module: BaseModule<T>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return module.getViewModel() as T
    }
}
package com.example.funnyfood.sl

import androidx.lifecycle.ViewModel

interface BaseModule<T : ViewModel> {
    fun getViewModel(): T
}
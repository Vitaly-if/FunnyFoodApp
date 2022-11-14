package com.example.funnyfood.sl.core

import androidx.lifecycle.ViewModel

interface BaseModule<T : ViewModel> {
    fun getViewModel(): T
}
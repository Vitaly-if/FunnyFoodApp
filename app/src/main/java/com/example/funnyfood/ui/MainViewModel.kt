package com.example.funnyfood.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(val Mapper: Context) : ViewModel() {

    fun fetchBooks() {
Log.i("MyTag", "fetchBooks MainViewModel")
    }

    fun observe() {

    }
}
package com.example.funnyfood.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.io.InputStreamReader

class MainViewModel(val Mapper: Context) : ViewModel() {

    fun fetchBooks() {
Log.i("MyTag", "fetchBooks MainViewModel")
    }

    fun observe() {


    }
}

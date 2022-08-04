package com.example.funnyfood.core

import android.app.Application
import com.example.funnyfood.ui.MainViewModel

class FunnyFoodApp: Application() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        mainViewModel = MainViewModel(applicationContext)
    }
}
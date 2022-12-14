package com.example.funnyfood.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.funnyfood.core.Read

class MainViewModel(
    private val navigator: Read<Int>,
    private val communication: NavigationCommunication,
) : ViewModel() {

    fun init() {
        communication.map(navigator.read())
    }

    fun observe(owner: LifecycleOwner, observer: Observer<Int>) {
        communication.observe(owner, observer)
    }

    fun navigateBack(): Boolean {
        val currentScreen = navigator.read()
        println("navigation back $currentScreen")
        val exit = currentScreen == 0
        if (!exit) {
            val newScreen = currentScreen - 1
            communication.map(newScreen)
        }
        return exit
    }

}

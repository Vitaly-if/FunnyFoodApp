package com.example.funnyfood.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.funnyfood.core.Abstract

interface RecipesCommunication : Abstract.Mapper {
    fun map(recipesUi: List<RecipeUi>)
    fun observe(owner: LifecycleOwner, observer: Observer<List<RecipeUi>>)

    class Base : RecipesCommunication {
        private val listLiveData = MutableLiveData<List<RecipeUi>>()
        override fun map(recipesUi: List<RecipeUi>) {
            listLiveData.value = recipesUi
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<List<RecipeUi>>) {
            listLiveData.observe(owner, observer)
        }
    }
}
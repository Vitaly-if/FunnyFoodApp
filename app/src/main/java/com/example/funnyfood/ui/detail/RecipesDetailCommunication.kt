package com.example.funnyfood.ui.detail

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.funnyfood.core.Abstract

interface RecipesDetailCommunication : Abstract.Mapper {
    fun map(recipesDetailUi: List<RecipeDetailUi>)
    fun observe(owner: LifecycleOwner, observer: Observer<List<RecipeDetailUi>>)

    class Base : RecipesDetailCommunication {
        private val listLiveData = MutableLiveData<List<RecipeDetailUi>>()
        override fun map(recipesDetailUi: List<RecipeDetailUi>) {
            listLiveData.value = recipesDetailUi
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<List<RecipeDetailUi>>) {
            listLiveData.observe(owner, observer)
        }
    }
}
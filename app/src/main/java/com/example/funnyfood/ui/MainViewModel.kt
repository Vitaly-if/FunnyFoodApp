package com.example.funnyfood.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funnyfood.domain.RecipesDomainToUiMapper
import com.example.funnyfood.domain.RecipesInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val recipesInteractor: RecipesInteractor,
    private val mapper: RecipesDomainToUiMapper,
    private val communication: RecipesCommunication
) : ViewModel() {

    fun fetchBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = recipesInteractor.fetchRecipes()
            val resultUI = resultDomain.map(mapper)
            withContext(Dispatchers.Main) {
                resultUI.map(communication)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<RecipeUi>>) {
        communication.observe(owner, observer)

    }
}

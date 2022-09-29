package com.example.funnyfood.ui.recipes

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funnyfood.core.Save
import com.example.funnyfood.domain.recipes.RecipesDomainToUiMapper
import com.example.funnyfood.domain.recipes.RecipesInteractor
import com.example.funnyfood.ui.NavigationCommunication
import com.example.funnyfood.ui.RecipesCommunication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecipeListViewModel(
    private val recipesInteractor: RecipesInteractor,
    private val mapper: RecipesDomainToUiMapper,
    private val communication: RecipesCommunication,
    private val navigator : Save<Int>,
    private val navigationCommunication: NavigationCommunication
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

    init {
        fetchBooks()
    }
}
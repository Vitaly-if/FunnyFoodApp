package com.example.funnyfood.ui.detail

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funnyfood.core.Save
import com.example.funnyfood.domain.detail.RecipesDetailDomainToUiMapper
import com.example.funnyfood.domain.detail.RecipeDetailInteractor
import com.example.funnyfood.ui.NavigationCommunication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecipeDetailViewModel(
    private val recipeDetailInteractor: RecipeDetailInteractor,
    private val mapper: RecipesDetailDomainToUiMapper,
    private val communication: RecipeDetailCommunication,
    private val navigator: Save<Int>,
    private val navigationCommunication: NavigationCommunication
) : ViewModel() {

    fun fetchRecipe() {
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = recipeDetailInteractor.fetchRecipeDetail()
            val resultUI = resultDomain.map(mapper)
            withContext(Dispatchers.Main) {
                resultUI.map(communication)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<RecipeDetailUi>) {
        communication.observe(owner, observer)
    }

}
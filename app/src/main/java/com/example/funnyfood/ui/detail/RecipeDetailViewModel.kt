package com.example.funnyfood.ui.detail

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funnyfood.core.Save
import com.example.funnyfood.domain.detail.RecipesDetailDomainToUiMapper
import com.example.funnyfood.domain.detail.RecipesDetailInteractor
import com.example.funnyfood.ui.NavigationCommunication
import com.example.funnyfood.ui.Navigator
import com.example.funnyfood.ui.detail.comment.CommentUi
import com.example.funnyfood.ui.detail.cookingstep.CookingStepUi
import com.example.funnyfood.ui.detail.ingredient.IngredientUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecipeDetailViewModel(

    private val recipeDetailInteractor: RecipesDetailInteractor,
    private val mapper: RecipesDetailDomainToUiMapper,
    private val communication: RecipesDetailCommunication,
    private val navigator: Save<Int>,
    private val navigationCommunication: NavigationCommunication
) : ViewModel() {

    fun fetchRecipe() {
        communication.map(listOf(RecipeDetailUi.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            val resultDomain = recipeDetailInteractor.fetchRecipeDetail()
            val resultUI = resultDomain.map(mapper)
            withContext(Dispatchers.Main) {
                resultUI.map(communication)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<RecipeDetailUi>>) {
        communication.observe(owner, observer)
    }
    fun init() {
        navigator.save(Navigator.Base.Screens.RECIPE_DETAIL_SCREEN)
    }

}
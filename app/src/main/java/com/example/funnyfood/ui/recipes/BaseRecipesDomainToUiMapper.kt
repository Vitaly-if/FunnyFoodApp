package com.example.funnyfood.ui.recipes

import com.example.funnyfood.domain.ErrorType
import com.example.funnyfood.domain.recipes.RecipeDomain
import com.example.funnyfood.domain.recipes.RecipeDomainToUiMapper
import com.example.funnyfood.domain.recipes.RecipesDomainToUiMapper
import com.example.funnyfood.ui.ResourceProvider

class BaseRecipesDomainToUiMapper(
    resourceProvider: ResourceProvider,
    private val recipeMapper: RecipeDomainToUiMapper
) : RecipesDomainToUiMapper(resourceProvider) {
    override fun map(list: List<RecipeDomain>) = RecipesUi.Base(list.map {
        it.map(recipeMapper)
    })
    override fun map(errorType: ErrorType)= RecipesUi.Base(listOf(RecipeUi.Fail(errorMessage(errorType))))
}
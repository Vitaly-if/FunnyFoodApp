package com.example.funnyfood.ui.recipes

import com.example.funnyfood.R
import com.example.funnyfood.domain.ErrorType
import com.example.funnyfood.domain.recipes.RecipeDomain
import com.example.funnyfood.domain.recipes.RecipeDomainToUiMapper
import com.example.funnyfood.domain.recipes.RecipesDomainToUiMapper
import com.example.funnyfood.ui.ResourceProvider

class BaseRecipesDomainToUiMapper(
    private val resourceProvider: ResourceProvider,
    private val recipeMapper: RecipeDomainToUiMapper
) : RecipesDomainToUiMapper {
    override fun map(list: List<RecipeDomain>) = RecipesUi.Base(list.map {
        it.map(recipeMapper)
    })

    override fun map(errorType: ErrorType): RecipesUi {
        val messageId = when (errorType) {
            ErrorType.NO_CONNECTION -> R.string.no_connection_message
            ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable_message
            else -> R.string.something_went_wrong
        }
        val message = resourceProvider.getString(messageId)
        return RecipesUi.Base(listOf(RecipeUi.Fail(message)))
    }
}
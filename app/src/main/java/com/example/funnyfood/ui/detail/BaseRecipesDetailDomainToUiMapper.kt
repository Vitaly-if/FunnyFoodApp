package com.example.funnyfood.ui.detail

import com.example.funnyfood.data.ToRecipeDetailMapper
import com.example.funnyfood.domain.ErrorType
import com.example.funnyfood.domain.detail.RecipeDetailDomain
import com.example.funnyfood.domain.detail.RecipeDetailDomainToUiMapper
import com.example.funnyfood.domain.detail.RecipesDetailDomainToUiMapper
import com.example.funnyfood.ui.ResourceProvider

class BaseRecipesDetailDomainToUiMapper(
    private val resourceProvider: ResourceProvider,
    private val recipeDetailMapper: RecipeDetailDomainToUiMapper
) : RecipesDetailDomainToUiMapper {
    override fun map(list: List<RecipeDetailDomain>): RecipesDetailUi {
        return RecipesDetailUi(list.map {
            it.map(recipeDetailMapper)
        })
    }

    override fun map(e: ErrorType): RecipesDetailUi {
        return RecipesDetailUi(listOf(RecipeDetailUi.Fail("")))
    }
}
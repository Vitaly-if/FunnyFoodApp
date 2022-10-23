package com.example.funnyfood.domain.recipes

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.ErrorType
import com.example.funnyfood.ui.recipes.RecipesUi

interface RecipesDomainToUiMapper: Abstract.Mapper {
    fun map(list: List<RecipeDomain>): RecipesUi
    fun map(errorType: ErrorType): RecipesUi
}
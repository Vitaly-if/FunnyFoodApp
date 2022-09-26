package com.example.funnyfood.domain

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.RecipesUi

interface RecipesDomainToUiMapper: Abstract.Mapper {
    fun map(list: List<RecipeDomain>): RecipesUi
    fun map(errorType: ErrorType): RecipesUi
}
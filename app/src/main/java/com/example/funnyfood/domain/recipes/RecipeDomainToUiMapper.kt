package com.example.funnyfood.domain.recipes

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.recipes.RecipeUi

interface RecipeDomainToUiMapper : Abstract.Mapper {
    fun map(
        id: Int, name: String,
        urlImg: String,
        cookingTime: String
    ): RecipeUi
}
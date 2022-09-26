package com.example.funnyfood.domain

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.RecipeUi

interface RecipeDomainToUiMapper : Abstract.Mapper {
    fun map(
        id: Int, name: String,
        urlImg: String,
        cookingTime: String
    ): RecipeUi
}
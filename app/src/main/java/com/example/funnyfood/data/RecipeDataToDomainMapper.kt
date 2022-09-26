package com.example.funnyfood.data

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.RecipeDomain

interface RecipeDataToDomainMapper : Abstract.Mapper {
    fun map(
        id: Int,
        name: String,
        urlImg: String,
        cookingTime: String
    ): RecipeDomain
}
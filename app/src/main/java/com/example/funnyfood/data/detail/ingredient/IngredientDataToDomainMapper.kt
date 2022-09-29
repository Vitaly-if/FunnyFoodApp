package com.example.funnyfood.data.detail.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.ingredient.IngredientDomain

interface IngredientDataToDomainMapper : Abstract.Mapper {
    fun map(
        name: String, quantity: String,
        unit: String
    ): IngredientDomain
}
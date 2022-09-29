package com.example.funnyfood.domain.detail.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.detail.ingredient.IngredientUi

interface IngredientDomainToUiMapper : Abstract.Mapper {
    fun map(
        name: String, quantity: String,
        unit: String
    ): IngredientUi
}
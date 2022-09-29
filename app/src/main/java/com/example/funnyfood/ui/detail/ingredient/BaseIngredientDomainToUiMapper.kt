package com.example.funnyfood.ui.detail.ingredient

import com.example.funnyfood.domain.detail.ingredient.IngredientDomainToUiMapper

class BaseIngredientDomainToUiMapper : IngredientDomainToUiMapper {
    override fun map(
        name: String, quantity: String,
        unit: String
    ) = IngredientUi(name, quantity, unit)

}
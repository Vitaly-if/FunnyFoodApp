package com.example.funnyfood.domain.detail.ingredient

import com.example.funnyfood.data.detail.ingredient.IngredientDataToDomainMapper

class BaseIngredientDataToDomainMapper : IngredientDataToDomainMapper {
    override fun map(
        name: String, quantity: String,
        unit: String
    ) = IngredientDomain(name, quantity, unit)

}
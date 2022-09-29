package com.example.funnyfood.data.detail.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.ingredient.IngredientDomain
import com.example.funnyfood.ui.detail.ingredient.IngredientUi

data class IngredientData(
    private val name: String, private val quantity: String,
    private val unit: String
): Abstract.Object<IngredientDomain, IngredientDataToDomainMapper> {
    override fun map(mapper: IngredientDataToDomainMapper): IngredientDomain {
        return mapper.map(name, quantity, unit)
    }
}

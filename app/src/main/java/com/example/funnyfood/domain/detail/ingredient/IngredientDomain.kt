package com.example.funnyfood.domain.detail.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.detail.ingredient.IngredientUi

data class IngredientDomain(
    private val name: String, private val quantity: String,
    private val unit: String
): Abstract.Object<IngredientUi, IngredientDomainToUiMapper> {
    override fun map(mapper: IngredientDomainToUiMapper): IngredientUi {
        return mapper.map(name, quantity, unit)
    }
}

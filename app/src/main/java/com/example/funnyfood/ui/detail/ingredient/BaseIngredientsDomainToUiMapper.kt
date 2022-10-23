package com.example.funnyfood.ui.detail.ingredient

import com.example.funnyfood.domain.detail.ingredient.IngredientDomain
import com.example.funnyfood.domain.detail.ingredient.IngredientDomainToUiMapper
import com.example.funnyfood.domain.detail.ingredient.IngredientsDomainToUiMapper

class BaseIngredientsDomainToUiMapper (
    private val ingredientDomainToUiMapper: IngredientDomainToUiMapper
) : IngredientsDomainToUiMapper {
    override fun map(list: List<IngredientDomain>): List<IngredientUi> {
        return list.map { it.map(ingredientDomainToUiMapper)}
    }
}
package com.example.funnyfood.domain.detail.ingredient

import com.example.funnyfood.data.detail.ingredient.IngredientData
import com.example.funnyfood.data.detail.ingredient.IngredientDataToDomainMapper
import com.example.funnyfood.data.detail.ingredient.IngredientsDataToDomainMapper

class BaseIngredientsDataToDomainMapper(
    private val ingredientDataToDomainMapper: IngredientDataToDomainMapper
) : IngredientsDataToDomainMapper {
    override fun map(list: List<IngredientData>): List<IngredientDomain> {
        return list.map { it.map(ingredientDataToDomainMapper) }
    }
}
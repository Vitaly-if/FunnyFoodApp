package com.example.funnyfood.data.detail.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.ingredient.IngredientDomain

interface IngredientsDataToDomainMapper : Abstract.Mapper {
    fun map(list: List<IngredientData>): List<IngredientDomain>
}
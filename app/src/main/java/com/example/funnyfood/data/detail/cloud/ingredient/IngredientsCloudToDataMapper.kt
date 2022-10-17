package com.example.funnyfood.data.detail.cloud.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.ingredient.IngredientData

interface IngredientsCloudToDataMapper : Abstract.Mapper {
    fun map(list: List<IngredientDTO>): List<IngredientData>
    class Base(
        private val mapper: IngredientCloudToDataMapper
    ) : IngredientsCloudToDataMapper {
        override fun map(list: List<IngredientDTO>): List<IngredientData> {
            return list.map { it.map(mapper) }
        }
    }
}
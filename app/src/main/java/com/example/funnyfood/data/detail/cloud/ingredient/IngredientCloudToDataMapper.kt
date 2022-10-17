package com.example.funnyfood.data.detail.cloud.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.ingredient.IngredientData

interface IngredientCloudToDataMapper : Abstract.Mapper {
    fun map(
        name: String,
        quantity: String,
        unit: String
    ): IngredientData

    class Base : IngredientCloudToDataMapper {
        override fun map(name: String, quantity: String, unit: String) = IngredientData(
            name, quantity, unit
        )
    }
}
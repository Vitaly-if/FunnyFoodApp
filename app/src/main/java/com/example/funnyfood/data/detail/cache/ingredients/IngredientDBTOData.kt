package com.example.funnyfood.data.detail.cache.ingredients

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.ingredient.IngredientData

interface IngredientDBTOData : Abstract.Mapper {
    fun map(name: String, quantity: String, unit: String): IngredientData
    class Base : IngredientDBTOData {
        override fun map(name: String, quantity: String, unit: String): IngredientData {
            return IngredientData(name, quantity, unit)
        }
    }
}
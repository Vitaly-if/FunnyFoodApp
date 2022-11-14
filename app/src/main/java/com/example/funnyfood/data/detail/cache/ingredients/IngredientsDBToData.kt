package com.example.funnyfood.data.detail.cache.ingredients

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.ingredient.IngredientData

interface IngredientsDBToData : Abstract.Mapper {
    fun map(list: List<IngredientDB>): List<IngredientData>
    class Base(private val mapper: IngredientDBTOData) : IngredientsDBToData {
        override fun map(list: List<IngredientDB>): List<IngredientData> {
            return list.map {
                it.map(mapper)
            }
        }
    }
}
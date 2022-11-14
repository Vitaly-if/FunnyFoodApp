package com.example.funnyfood.data.detail.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.ingredients.IngredientDB

interface IngredientDataToDBMapper : Abstract.Mapper {
    fun map(name: String, quantity: String,
           unit: String) : IngredientDB
    class Base : IngredientDataToDBMapper {
        override fun map(name: String, quantity: String, unit: String): IngredientDB {
            val ingredientDB = IngredientDB()
            return ingredientDB.also {
                it.name = name
                it.quantity = quantity
                it.unit = unit
            }
        }
    }
}
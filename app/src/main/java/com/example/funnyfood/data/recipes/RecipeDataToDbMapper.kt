package com.example.funnyfood.data.recipes

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.recipes.cache.RecipeDB

interface RecipeDataToDbMapper : Abstract.Mapper {

    fun mapBy(
        id: Int,
        name: String,
        urlImg: String,
        cookingTime: String
    ): RecipeDB

    class Base : RecipeDataToDbMapper {
        override fun mapBy(
            id: Int,
            name: String,
            urlImg: String,
            cookingTime: String
        ): RecipeDB {
            val recipeDB = RecipeDB()
            recipeDB.id = id
            recipeDB.name = name
            recipeDB.urlImg = urlImg
            recipeDB.cookingTime = cookingTime
            return recipeDB
        }
    }
}
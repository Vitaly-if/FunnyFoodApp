package com.example.funnyfood.data

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.cache.DbWrapper
import com.example.funnyfood.data.cache.RecipeDB

interface RecipeDataToDbMapper : Abstract.Mapper {

    fun mapToDb(
        id: Int,
        name: String,
        urlImg: String,
        cookingTime: String,
        db: DbWrapper
    ): RecipeDB

    class Base : RecipeDataToDbMapper {
        override fun mapToDb(
            id: Int,
            name: String,
            urlImg: String,
            cookingTime: String,
            db: DbWrapper
        ): RecipeDB {
            val recipeDB = db.createObject(id)
            recipeDB.name = name
            recipeDB.urlImg = urlImg
            recipeDB.cookingTime = cookingTime
            return recipeDB
        }
    }
}
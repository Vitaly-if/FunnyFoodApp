package com.example.funnyfood.data

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.cache.RecipeDB
import com.example.funnyfood.data.cache.RecipeRealm

interface RecipesCacheMapper : Abstract.Mapper {
    fun map(recipeDdList: List<Abstract.Object<RecipeData, ToRecipeDataMapper>>): List<RecipeData>

    class Base(private val recipeDbList: List<RecipeDB>, private val mapper: ToRecipeDataMapper) :
        RecipesCacheMapper {
        override fun map(recipeDbList: List<Abstract.Object<RecipeData, ToRecipeDataMapper>>): List<RecipeData> {
            return recipeDbList.map { recipeDB -> recipeDB.map(mapper) }
        }


    }
}
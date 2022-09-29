package com.example.funnyfood.data.recipes

import com.example.funnyfood.core.Abstract

interface RecipesCacheMapper : Abstract.Mapper {
    fun map(recipeDdList: List<Abstract.Object<RecipeData, ToRecipeDataMapper>>): List<RecipeData>

    class Base(private val mapper: ToRecipeDataMapper) :
        RecipesCacheMapper {
        override fun map(recipeDbList: List<Abstract.Object<RecipeData, ToRecipeDataMapper>>): List<RecipeData> {
            return recipeDbList.map { recipeDB -> recipeDB.map(mapper) }
        }


    }
}
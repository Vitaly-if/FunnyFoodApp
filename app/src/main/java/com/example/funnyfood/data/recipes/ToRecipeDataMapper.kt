package com.example.funnyfood.data.recipes

import com.example.funnyfood.core.Abstract

interface ToRecipeDataMapper : Abstract.Mapper {

    fun map(
        id: Int,
        name: String,
        urlImg: String,
        cookingTime: String
    ): RecipeData

    class Base : ToRecipeDataMapper {
        override fun map(id: Int, name: String, urlImg: String, cookingTime: String): RecipeData {
            return RecipeData(id, name, urlImg, cookingTime)
        }
    }
}
package com.example.funnyfood.data

import com.example.funnyfood.core.Abstract

interface RecipesCloudMapper : Abstract.Mapper {
    fun map(cloudList: List<Abstract.Object<RecipeData, ToRecipeDataMapper>>): List<RecipeData>

    class Base(private val recipeMapper: ToRecipeDataMapper) : RecipesCloudMapper {
        override fun map(cloudList: List<Abstract.Object<RecipeData, ToRecipeDataMapper>>): List<RecipeData> {
            return cloudList.map { recipeDTO ->
                recipeDTO.map(recipeMapper)
            }
        }
    }
}
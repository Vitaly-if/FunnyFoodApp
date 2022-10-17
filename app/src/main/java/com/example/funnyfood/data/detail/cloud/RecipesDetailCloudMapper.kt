package com.example.funnyfood.data.detail.cloud

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.ToRecipeDetailMapper
import com.example.funnyfood.data.detail.RecipeDetailData

interface RecipesDetailCloudMapper : Abstract.Mapper {
    fun map(recipes: List<RecipeDetailDTO>): List<RecipeDetailData>
    class Base(private val mapper: ToRecipeDetailMapper) : RecipesDetailCloudMapper {
        override fun map(recipes: List<RecipeDetailDTO>): List<RecipeDetailData> {
           return recipes.map{recipeCloud -> recipeCloud.map(mapper)
           }
        }
    }
}
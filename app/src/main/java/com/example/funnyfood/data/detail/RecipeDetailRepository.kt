package com.example.funnyfood.data.detail

import com.example.funnyfood.domain.detail.RecipeDetailDomain

interface RecipeDetailRepository {

    suspend fun fetchRecipeDetail() : RecipeDetailData

    class Base(
        private val cloudDataSource: RecipeDetailCloudDataSource,
        private val cacheDataSource: RecipeDetailCacheDataSource,
        private val recipeCloudMapper: RecipeDetailCloudMapper,
        private val resipeCacheDataSource: RecipeDetailCacheMapper
    ) : RecipeDetailRepository {
        override suspend fun fetchRecipeDetail() = try {
           val recipeCach = cacheDataSource.fetchRecipe()
            if (recipeCach.isEmpty()) {
                val recipeCloud = cloudDataSource.fetchRecipe()
                val recipe = recipeCloudMapper.map(recipeCloud)
                cacheDataSource.saveRecipe(recipe)
                RecipeDetailData.
            }
        }
    }
}
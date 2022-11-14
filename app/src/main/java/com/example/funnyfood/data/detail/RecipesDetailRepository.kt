package com.example.funnyfood.data.detail

import com.example.funnyfood.data.detail.cache.RecipesDetailCacheDataSource
import com.example.funnyfood.data.detail.cloud.RecipeDetailCloudDataSource
import com.example.funnyfood.data.detail.cloud.RecipesDetailCloudMapper
import com.example.funnyfood.ui.recipes.RecipeCache

interface RecipesDetailRepository {

    suspend fun fetchRecipesDetail(): RecipesDetailData

    class Base(
        private val cloudDataSource: RecipeDetailCloudDataSource,
        private val cacheDataSource: RecipesDetailCacheDataSource,
        private val recipesCloudMapper: RecipesDetailCloudMapper,
        private val recipeCache: RecipeCache,
        private val recipesCacheDataMapper: RecipesDetailCacheMapper,
    ) : RecipesDetailRepository {
        override suspend fun fetchRecipesDetail() = try {
            val recipeId = recipeCache.read()
            val recipesCacheList = cacheDataSource.fetchDetailRecipes()
            if (recipesCacheList.isEmpty()) {
                val recipesDetailCloudList = cloudDataSource.fetchRecipes(recipeId)
                val recipe = recipesCloudMapper.map(recipesDetailCloudList)
                cacheDataSource.saveDetailRecipes(recipe)
                RecipesDetailData.Success(recipe)
            } else {
                RecipesDetailData.Success(recipesCacheDataMapper.map(recipesCacheList))
            }
        } catch (e: Exception) {
            RecipesDetailData.Fail(e)
        }
    }
}
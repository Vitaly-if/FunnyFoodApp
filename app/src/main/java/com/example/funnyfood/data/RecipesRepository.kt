package com.example.funnyfood.data

import com.example.funnyfood.data.cache.RecipesCacheDataSource
import com.example.funnyfood.data.cloud.RecipeCloudDataSource

interface RecipesRepository {

    suspend fun fetchRecipes(): RecipesData

    class Base(
        private val cloudDataSource: RecipeCloudDataSource,
        private val cacheDataSource: RecipesCacheDataSource,
        private val recipesCloudMapper: RecipesCloudMapper,
        private val recipesCacheDataSource: RecipesCacheMapper
    ) : RecipesRepository {
        override suspend fun fetchRecipes() = try {
            val recipesCacheList = cacheDataSource.fetchRecipes()
            if (recipesCacheList.isEmpty()) {
                val recipesCloudList = cloudDataSource.fetchRecipes()
                val recipes = recipesCloudMapper.map(recipesCloudList)
                cacheDataSource.saveRecipes(recipes)
                RecipesData.Success(recipes)
            } else {
                RecipesData.Success(recipesCacheDataSource.map(recipesCacheList))
            }
        } catch (e: Exception) {
            RecipesData.Fail(e)
        }
    }


}

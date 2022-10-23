package com.example.funnyfood.data.detail

import com.example.funnyfood.data.detail.cloud.RecipeDetailCloudDataSource
import com.example.funnyfood.data.detail.cloud.RecipesDetailCloudMapper
import com.example.funnyfood.ui.recipes.RecipeCache

interface RecipesDetailRepository {

    suspend fun fetchRecipesDetail(): RecipesDetailData

    class Base(
        private val cloudDataSource: RecipeDetailCloudDataSource,
      //  private val cacheDataSource: RecipeDetailCacheDataSource,
        private val recipesCloudMapper: RecipesDetailCloudMapper,
        private val recipeCache: RecipeCache,
       // private val recipesCacheDataSource: RecipeDetailCacheMapper
    ) : RecipesDetailRepository {
        override suspend fun fetchRecipesDetail() = try {
            val recipeId = recipeCache.read()
           // val recipesCacheList = cacheDataSource.fetchRecipes()
            val test = true
           // if (test) {
            println("repository id recipe dto")
                val recipesDetailCloudList = cloudDataSource.fetchRecipes(recipeId)
                val recipe = recipesCloudMapper.map(recipesDetailCloudList)
              //  cacheDataSource.saveRecipe(recipe)
                RecipesDetailData.Success(recipe)
          //  } else {
               // RecipesDetailData.Success(recipesCacheDataSource.map(recipesCachList))
         //   }
        } catch (e: Exception) {
            RecipesDetailData.Fail(e)
        }
    }
}
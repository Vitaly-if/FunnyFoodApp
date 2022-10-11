package com.example.funnyfood.data.detail.cloud

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface RecipeDetailCloudDataSource {
    suspend fun fetchRecipes(recipeId: Int): List<RecipeDetailCloud>

    class Base(
        private val service: RecipeDetailService,
        private val gson: Gson
    ) : RecipeDetailCloudDataSource {

        override suspend fun fetchRecipes(recipeId: Int): List<RecipeDetailCloud> {
            return gson.fromJson(
                service.fetchDetailRecipe(recipeId).string(),
                object : TypeToken<List<RecipeDetailCloud>>() {}.type
            )
        }

    }
}
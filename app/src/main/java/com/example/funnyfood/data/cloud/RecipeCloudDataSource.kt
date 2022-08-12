package com.example.funnyfood.data.cloud

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface RecipeCloudDataSource {

    suspend fun fetchRecipes(): List<RecipeDTO>

    class Base(
        private val service: RecipeService,
        private val gson: Gson
    ) : RecipeCloudDataSource {
        private val type = object : TypeToken<List<RecipeDTO>>() {}.type
        override suspend fun fetchRecipes(): List<RecipeDTO> {
            return gson.fromJson(service.fetchRecipes().string(), type)
        }
    }
}
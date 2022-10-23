package com.example.funnyfood.data.detail.cloud

import android.content.res.Resources
import com.example.funnyfood.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader

interface RecipeDetailCloudDataSource {
    suspend fun fetchRecipes(recipeId: Int): List<RecipeDetailDTO>

    abstract class Abstract(private val gson: Gson) : RecipeDetailCloudDataSource {
        override suspend fun fetchRecipes(recipeId: Int): List<RecipeDetailDTO> {
            val list = listOf<RecipeDetailDTO>(
                gson.fromJson(
                    getDataAsString(recipeId),
                    object : TypeToken<RecipeDetailDTO>() {}.type
                )
            )
            return list
        }

        protected abstract suspend fun getDataAsString(recipeId: Int): String
    }

    class Base(
        private val service: RecipeDetailService,
        private val gson: Gson,
    ) : RecipeDetailCloudDataSource.Abstract(gson) {
        override suspend fun getDataAsString(recipeId: Int) =
            service.fetchDetailRecipe(recipeId).string()

        override suspend fun fetchRecipes(recipeId: Int): List<RecipeDetailDTO> {
            val list = listOf<RecipeDetailDTO>(
                gson.fromJson(
                    service.fetchDetailRecipe(recipeId).string(),
                    object : TypeToken<RecipeDetailDTO>() {}.type
                )
            )
            return list
        }
    }

    class Mock(
        private val resources: Resources,
        gson: Gson
    ) : RecipeDetailCloudDataSource.Abstract(gson) {
        override suspend fun getDataAsString(recipeId: Int) =
            resources.openRawResource(R.raw.recipe).bufferedReader()
                .use(BufferedReader::readText)


    }
}
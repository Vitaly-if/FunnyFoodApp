package com.example.funnyfood.data.recipes.cloud

import okhttp3.ResponseBody
import retrofit2.http.GET

interface RecipeService {

    @GET("recipes")
    suspend fun fetchRecipes(): ResponseBody
}
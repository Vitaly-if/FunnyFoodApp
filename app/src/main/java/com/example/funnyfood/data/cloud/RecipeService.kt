package com.example.funnyfood.data.cloud

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    @GET("recipes")
    suspend fun fetchRecipes(): ResponseBody
}
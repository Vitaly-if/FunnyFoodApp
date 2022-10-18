package com.example.funnyfood.data.detail.cloud

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeDetailService {

    @GET("recipe/{id}/")
    suspend fun fetchDetailRecipe(
        @Path("id") recipeId: Int
    ): ResponseBody
}
package com.example.funnyfood.data.recipes.cloud

import com.google.gson.annotations.SerializedName

data class FavoritesDTO(
    @SerializedName("username") val userName: String)

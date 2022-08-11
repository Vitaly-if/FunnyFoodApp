package com.example.funnyfood.data.cloud

import com.google.gson.annotations.SerializedName

data class RecipeDTO(
    @SerializedName("id") val id: String,
    @SerializedName("author") val author: String,
    @SerializedName("url") val url: String,
    @SerializedName("download_url") val downloadUrl: String
)

package com.example.funnyfood.data.detail.cloud

import com.google.gson.annotations.SerializedName

data class IngredientDTO(
    @SerializedName("name") val name: String,
    @SerializedName("quantity") val quantity: String,
    @SerializedName("unit") val unit: String
)

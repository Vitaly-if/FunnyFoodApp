package com.example.funnyfood.data.detail.cloud

import com.google.gson.annotations.SerializedName

data class CookingStepDTO(
    @SerializedName("order") val order: String,
    @SerializedName("step") val step: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("status") val status: String
)

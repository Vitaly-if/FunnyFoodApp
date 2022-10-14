package com.example.funnyfood.data.detail.cloud

import com.google.gson.annotations.SerializedName

data class FavoriteDTO(
    @SerializedName("username") val userName: String)

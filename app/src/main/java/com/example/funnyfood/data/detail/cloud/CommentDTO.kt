package com.example.funnyfood.data.detail.cloud

import com.google.gson.annotations.SerializedName

data class CommentDTO(
    @SerializedName("author") val author: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("date") val date: String,
    @SerializedName("comment") val comment: String,
    @SerializedName("image") val image: String,

    )

package com.example.funnyfood.data.detail.cloud.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.comment.CommentData
import com.google.gson.annotations.SerializedName

data class CommentDTO(
    @SerializedName("author") val author: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("date") val date: String,
    @SerializedName("comment") val comment: String,
    @SerializedName("image") val image: String
) : Abstract.Object<CommentData, CommentCloudToDataMapper> {
    override fun map(mapper: CommentCloudToDataMapper): CommentData {
        return mapper.map(author, avatar, date, comment, image)
    }
}

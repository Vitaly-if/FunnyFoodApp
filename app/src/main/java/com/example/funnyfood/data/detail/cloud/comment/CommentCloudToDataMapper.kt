package com.example.funnyfood.data.detail.cloud.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.comment.CommentData

interface CommentCloudToDataMapper : Abstract.Mapper {
    fun map(
        author: String, avatar: String,
        date: String,
        comment: String,
        image: String
    ): CommentData

    class Base : CommentCloudToDataMapper {
        override fun map(
            author: String,
            avatar: String,
            date: String,
            comment: String,
            image: String
        ): CommentData = CommentData(author, avatar, date, comment, image)
    }
}
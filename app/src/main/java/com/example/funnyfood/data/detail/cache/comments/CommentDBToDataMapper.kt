package com.example.funnyfood.data.detail.cache.comments

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.comment.CommentData

interface CommentDBToDataMapper : Abstract.Mapper {
    fun map(
        author: String,
        avatar: String,
        date: String,
        comment: String,
        image: String,
    ): CommentData

    class Base : CommentDBToDataMapper {
        override fun map(
            author: String,
            avatar: String,
            date: String,
            comment: String,
            image: String,
        ): CommentData {
            return CommentData(author, avatar, date, comment, image)
        }
    }
}
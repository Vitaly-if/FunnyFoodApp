package com.example.funnyfood.data.detail.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.comments.CommentDB

interface CommentDataToDBMapper : Abstract.Mapper {
    fun map(
        author: String, avatar: String,
        date: String,
        comment: String,
        image: String,
    ): CommentDB

    class Base() : CommentDataToDBMapper {
        override fun map(
            author: String,
            avatar: String,
            date: String,
            comment: String,
            image: String,
        ): CommentDB {
            val commentDB = CommentDB()
            return commentDB.also {
                it.author = author
                it.comment = comment
                it.date = date
                it.avatar = avatar
                it.image = image
            }
        }
    }
}
package com.example.funnyfood.data.detail.cache.comments

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.comment.CommentData

interface CommentsDBToDataMapper : Abstract.Mapper {
    fun map(list: List<CommentDB>): List<CommentData>
    class Base(val mapper: CommentDBToDataMapper) : CommentsDBToDataMapper {
        override fun map(list: List<CommentDB>): List<CommentData> {
            return list.map {
                it.map(mapper)
            }
        }
    }
}
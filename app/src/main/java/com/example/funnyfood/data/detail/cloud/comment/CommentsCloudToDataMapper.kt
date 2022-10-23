package com.example.funnyfood.data.detail.cloud.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.comment.CommentData

interface CommentsCloudToDataMapper : Abstract.Mapper {
    fun map(list: List<CommentDTO>): List<CommentData>
    class Base(
        private val mapper: CommentCloudToDataMapper
    ) : CommentsCloudToDataMapper {
        override fun map(list: List<CommentDTO>): List<CommentData> {
            return list.map { it.map(mapper) }
        }
    }
}
package com.example.funnyfood.domain.detail.comment

import com.example.funnyfood.data.detail.comment.CommentData
import com.example.funnyfood.data.detail.comment.CommentDataToDomainMapper
import com.example.funnyfood.data.detail.comment.CommentsDataToDomainMapper

class BaseCommentsDataToDomainMapper(
    private val commentDataToDomainMapper: CommentDataToDomainMapper
) : CommentsDataToDomainMapper {
    override fun map(list: List<CommentData>): List<CommentDomain> {
        return list.map { it.map(commentDataToDomainMapper) }
    }
}
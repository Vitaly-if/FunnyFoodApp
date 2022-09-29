package com.example.funnyfood.domain.detail.comment

import com.example.funnyfood.data.detail.comment.CommentDataToDomainMapper

class BaseCommentDataToDomainMapper : CommentDataToDomainMapper {
    override fun map(
        author: String,
        avatar: String,
        date: String,
        comment: String,
        image: String
    ) = CommentDomain(author, avatar, date, comment, image)
}
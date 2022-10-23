package com.example.funnyfood.ui.detail.comment

import com.example.funnyfood.domain.detail.comment.CommentDomainToUiMapper

class BaseCommentDomainToUiMapper : CommentDomainToUiMapper {
    override fun map(
        author: String,
        avatar: String,
        date: String,
        comment: String,
        image: String
    ) = CommentUi(author, avatar, date, comment, image)
}
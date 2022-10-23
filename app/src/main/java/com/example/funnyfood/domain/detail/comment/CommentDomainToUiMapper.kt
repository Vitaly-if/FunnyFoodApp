package com.example.funnyfood.domain.detail.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.detail.comment.CommentUi

interface CommentDomainToUiMapper : Abstract.Mapper {
    fun map(
        author: String, avatar: String,
        date: String,
        comment: String,
        image: String
    ): CommentUi
}
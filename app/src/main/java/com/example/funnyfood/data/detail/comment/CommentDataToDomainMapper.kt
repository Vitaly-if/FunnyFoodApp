package com.example.funnyfood.data.detail.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.comment.CommentDomain
import com.example.funnyfood.ui.detail.comment.CommentUi

interface CommentDataToDomainMapper : Abstract.Mapper {
    fun map(
        author: String, avatar: String,
        date: String,
        comment: String,
        image: String
    ): CommentDomain
}
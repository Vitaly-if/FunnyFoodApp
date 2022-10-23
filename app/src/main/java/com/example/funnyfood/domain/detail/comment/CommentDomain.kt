package com.example.funnyfood.domain.detail.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.detail.comment.CommentUi

data class CommentDomain(
    private val author: String, private val avatar: String,
    private val date: String,
    private val comment: String,
    private val image: String
) : Abstract.Object<CommentUi, CommentDomainToUiMapper> {
    override fun map(mapper: CommentDomainToUiMapper): CommentUi {
        return mapper.map(author, avatar, date, comment, image)
    }
}

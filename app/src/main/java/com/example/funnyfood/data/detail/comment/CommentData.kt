package com.example.funnyfood.data.detail.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.comment.CommentDomain

data class CommentData(
    private val author: String, private val avatar: String,
    private val date: String,
    private val comment: String,
    private val image: String
) : Abstract.Object<CommentDomain, CommentDataToDomainMapper> {
    override fun map(mapper: CommentDataToDomainMapper): CommentDomain {
        return mapper.map(author, avatar, date, comment, image)
    }
}

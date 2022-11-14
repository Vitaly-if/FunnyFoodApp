package com.example.funnyfood.data.detail.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.comments.CommentDB
import com.example.funnyfood.domain.detail.comment.CommentDomain

data class CommentData(
    private val author: String, private val avatar: String,
    private val date: String,
    private val comment: String,
    private val image: String,
) : Abstract.Object<CommentDomain, CommentDataToDomainMapper>,
    Abstract.Mapper.ToDb<CommentDB, CommentDataToDBMapper> {
    override fun map(mapper: CommentDataToDomainMapper): CommentDomain {
        return mapper.map(author, avatar, date, comment, image)
    }

    override fun mapBy(mapper: CommentDataToDBMapper): CommentDB {
        return mapper.map(author, avatar, date, comment, image)
    }
}

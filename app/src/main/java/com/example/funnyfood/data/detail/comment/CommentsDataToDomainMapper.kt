package com.example.funnyfood.data.detail.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.comment.CommentDomain

interface CommentsDataToDomainMapper : Abstract.Mapper {
    fun map(list: List<CommentData>): List<CommentDomain>
}
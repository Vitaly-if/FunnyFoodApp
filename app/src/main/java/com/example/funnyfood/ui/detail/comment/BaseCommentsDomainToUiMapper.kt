package com.example.funnyfood.ui.detail.comment

import com.example.funnyfood.domain.detail.comment.*

class BaseCommentsDomainToUiMapper(
    private val commentDomainToUiMapper: CommentDomainToUiMapper
) : CommentsDomainToUiMapper {
    override fun map(list: List<CommentDomain>): List<CommentUi> {
        return list.map { it.map(commentDomainToUiMapper) }
    }
}

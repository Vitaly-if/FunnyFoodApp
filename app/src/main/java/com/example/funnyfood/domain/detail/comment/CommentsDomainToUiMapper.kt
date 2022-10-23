package com.example.funnyfood.domain.detail.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.comment.CommentData
import com.example.funnyfood.ui.detail.comment.CommentUi

interface CommentsDomainToUiMapper : Abstract.Mapper {
    fun map(list: List<CommentDomain>): List<CommentUi>
}
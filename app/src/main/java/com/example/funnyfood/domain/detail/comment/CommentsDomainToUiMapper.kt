package com.example.funnyfood.domain.detail.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.detail.comment.CommentUi

interface CommentsDomainToUiMapper : Abstract.Mapper {
    fun map(list: List<CommentData>): List<CommentUi>
}
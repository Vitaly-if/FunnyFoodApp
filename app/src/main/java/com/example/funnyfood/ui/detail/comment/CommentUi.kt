package com.example.funnyfood.ui.detail.comment

import com.example.funnyfood.core.Abstract

data class CommentUi(
    private val author: String, private val avatar: String,
    private val date: String,
    private val comment: String,
    private val image: String
): Abstract.Object<Unit, Abstract.Mapper.Empty> {
    override fun map(mapper: Abstract.Mapper.Empty) {
        //todo fix empty mapper
    }
}


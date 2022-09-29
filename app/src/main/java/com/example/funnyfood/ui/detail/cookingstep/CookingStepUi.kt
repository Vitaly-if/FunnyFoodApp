package com.example.funnyfood.ui.detail.cookingstep

import com.example.funnyfood.core.Abstract

data class CookingStepUi(
    private val order: Int, private val step: String,
    private val duration: String,
    private val status: Boolean
): Abstract.Object<Unit, Abstract.Mapper.Empty> {
    override fun map(mapper: Abstract.Mapper.Empty) {
        //todo fix empty mapper
    }
}
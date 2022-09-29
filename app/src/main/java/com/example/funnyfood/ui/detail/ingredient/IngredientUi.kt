package com.example.funnyfood.ui.detail.ingredient

import com.example.funnyfood.core.Abstract

data class IngredientUi(
    private val name: String, private val quantity: String,
    private val unit: String
): Abstract.Object<Unit, Abstract.Mapper.Empty> {
    override fun map(mapper: Abstract.Mapper.Empty) {
        //todo fix empty mapper
    }
}

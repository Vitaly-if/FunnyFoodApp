package com.example.funnyfood.ui.detail.ingredient

import android.widget.TextView
import com.example.funnyfood.core.Abstract

data class IngredientUi(
    private val name: String, private val quantity: String,
    private val unit: String
) : Abstract.Object<Unit, Abstract.Mapper.Empty> {
    override fun map(mapper: Abstract.Mapper.Empty) {
        //todo fix empty mapper
    }

    fun show(ingredientName: TextView, ingredientAmount: TextView) {
        ingredientName.text = name
        ingredientAmount.text = quantity
    }
}

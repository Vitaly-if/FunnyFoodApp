package com.example.funnyfood.ui.detail.ingredient

import android.widget.TextView
import com.example.funnyfood.core.Abstract
import com.example.funnyfood.core.Same

data class IngredientUi(
    private val name: String, private val quantity: String,
    private val unit: String
) : Abstract.Object<Unit, Abstract.Mapper.Empty>, Same<IngredientUi> {
    override fun map(mapper: Abstract.Mapper.Empty) {
        //todo fix empty mapper
    }

    fun show(ingredientName: TextView, ingredientAmount: TextView) {
        ingredientName.text = name
        ingredientAmount.text = "$quantity $unit"//todo fix
    }

    override fun itemToCompare(item: IngredientUi) = item.name == name

}

package com.example.funnyfood.ui.detail.ingredient

import android.view.View
import com.example.funnyfood.databinding.RecipeIngredientItemBinding
import com.example.funnyfood.ui.detail.BaseViewHolder

class IngredientViewHolder(view: View) : BaseViewHolder<IngredientUi>(view) {
    private val binding = RecipeIngredientItemBinding.bind(view)
    override fun bind(item: IngredientUi) {
        with(binding) {
            item.show(ingredientName, ingredientAmount)
        }
    }
}
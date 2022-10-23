package com.example.funnyfood.ui.detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.funnyfood.databinding.RecipeIngredientItemBinding
import com.example.funnyfood.ui.detail.ingredient.IngredientUi

abstract class RecipeDetailBaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    open fun onBind(model: IngredientUi) {}
}

class RecipeDetailViewHolder(view: View) : RecipeDetailBaseViewHolder(view) {
    val binding = RecipeIngredientItemBinding.bind(view)
    override fun onBind(model: IngredientUi) {
        with(binding) {
            model.show(ingredientName, ingredientAmount)
        }
    }
}
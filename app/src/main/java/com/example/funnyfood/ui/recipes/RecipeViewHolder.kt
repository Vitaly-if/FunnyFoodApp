package com.example.funnyfood.ui.recipes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.funnyfood.databinding.RecipeItemErrorBinding
import com.example.funnyfood.databinding.RecipeItemLayoutBinding

abstract class RecipeBaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    protected val view: View = view

    open fun onBind(model: RecipeUi, recipeListener: RecipesAdapter.RecipeListener) {}
}

class RecipeViewHolder(view: View) : RecipeBaseViewHolder(view) {
private val binding = RecipeItemLayoutBinding.bind(view)
    override fun onBind(model: RecipeUi, recipeListener: RecipesAdapter.RecipeListener) =
        with(binding) {
            model.show(view)
            binding.root.setOnClickListener {
                model.open(recipeListener)
            }
        }
}

class FailRecipeVewHolder(view: View) : RecipeBaseViewHolder(view) {
    private val binding = RecipeItemErrorBinding.bind(view)
    override fun onBind(model: RecipeUi, recipeListener: RecipesAdapter.RecipeListener) {
        model.show(view)
    }
}
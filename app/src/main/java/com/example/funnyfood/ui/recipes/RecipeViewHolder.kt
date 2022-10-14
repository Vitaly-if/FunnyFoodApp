package com.example.funnyfood.ui.recipes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.funnyfood.databinding.RecipeItemLayoutBinding

abstract class RecipeBaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    open fun onBind(model: RecipeUi, recipeListener: RecipesAdapter.RecipeListener) {}
}

class RecipeViewHolder(view: View) : RecipeBaseViewHolder(view) {
    val binding = RecipeItemLayoutBinding.bind(view)


    override fun onBind(model: RecipeUi, recipeListener: RecipesAdapter.RecipeListener) =
        with(binding) {
            model.show(nameTextView, timeTextView, recipeImageView)
            binding.root.setOnClickListener {
                model.open(recipeListener)
            }
        }


}
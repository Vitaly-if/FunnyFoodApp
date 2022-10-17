package com.example.funnyfood.ui.detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.funnyfood.databinding.RecipeItemDescriptionHeadBinding
import com.example.funnyfood.databinding.RecipeItemLayoutBinding

abstract class RecipeDetailBaseViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
    open fun onBind(model: RecipeDetailUi) {}
}
class RecipeDetailViewHolder(view: View) : RecipeDetailBaseViewHolder(view) {
    val binding = RecipeItemDescriptionHeadBinding.bind(view)
    override fun onBind(model: RecipeDetailUi) {
        with(binding) {
          model.show(recipeName, recipeTimeCocking)
        }
    }
}
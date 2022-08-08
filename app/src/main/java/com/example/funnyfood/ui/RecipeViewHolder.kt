package com.example.funnyfood.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.funnyfood.R
import com.example.funnyfood.core.Abstract
import com.example.funnyfood.databinding.RecipeItemLayoutBinding

abstract class RecipeBaseViewHolder(view: View) : RecyclerView.ViewHolder(view){
    open fun onBind(model: RecipeUiModel.Base) {}
}

class RecipeViewHolder(view: View) : RecipeBaseViewHolder(view) {
    val binding = RecipeItemLayoutBinding.bind(view)
   // val name: TextView = view.findViewById(R.id.nametextView)
    override fun onBind(model: RecipeUiModel.Base) = with(binding) {
        model.show(nameTextView, timeTextView, recipeImageView)
    }


}
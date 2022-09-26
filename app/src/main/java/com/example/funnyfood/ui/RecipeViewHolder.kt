package com.example.funnyfood.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.funnyfood.databinding.RecipeItemLayoutBinding

abstract class RecipeBaseViewHolder(view: View) : RecyclerView.ViewHolder(view){
    open fun onBind(model: RecipeUi) {}
}

class RecipeViewHolder(view: View) : RecipeBaseViewHolder(view) {
    val binding = RecipeItemLayoutBinding.bind(view)
   // val name: TextView = view.findViewById(R.id.nametextView)
   override fun onBind(model: RecipeUi) = with(binding) {
        model.show(nameTextView, timeTextView, recipeImageView)
    }


}
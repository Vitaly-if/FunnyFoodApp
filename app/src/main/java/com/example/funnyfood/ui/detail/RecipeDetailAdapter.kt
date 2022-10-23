package com.example.funnyfood.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.funnyfood.R
import com.example.funnyfood.ui.detail.ingredient.IngredientUi

class RecipeDetailAdapter() : RecyclerView.Adapter<RecipeDetailBaseViewHolder>() {

    private val items = ArrayList<IngredientUi>()

    fun setData(list: List<IngredientUi>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeDetailBaseViewHolder {
        return RecipeDetailViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recipe_ingredient_item, parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecipeDetailBaseViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
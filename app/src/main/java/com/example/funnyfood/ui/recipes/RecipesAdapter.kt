package com.example.funnyfood.ui.recipes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.funnyfood.R

class RecipesAdapter(
    private val recipeListener: RecipeListener
) : RecyclerView.Adapter<RecipeBaseViewHolder>() {

    private val items = ArrayList<RecipeUi>()

    fun setData(list: List<RecipeUi>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeBaseViewHolder {

        return RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recipe_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipeBaseViewHolder, position: Int) {
        holder.onBind(items[position], recipeListener)
    }

    override fun getItemCount() = items.size

    interface RecipeListener {
        fun showRecipe(id: Int)
    }
}


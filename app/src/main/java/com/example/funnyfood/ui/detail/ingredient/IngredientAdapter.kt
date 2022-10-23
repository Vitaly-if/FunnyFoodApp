package com.example.funnyfood.ui.detail.ingredient

import android.view.ViewGroup
import com.example.funnyfood.R
import com.example.funnyfood.ui.detail.BaseAdapter
import com.example.funnyfood.ui.detail.DiffUtilCallback

class IngredientAdapter : BaseAdapter<IngredientUi, IngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        return IngredientViewHolder(
            R.layout.recipe_ingredient_item.makeView(parent)
        )
    }

    override fun diffUtilCallback(
        list: List<IngredientUi>,
        data: List<IngredientUi>,
    ) = IngredientDiffUtilCallback(list, data)

    inner class IngredientDiffUtilCallback(
        oldList: List<IngredientUi>,
        newList: List<IngredientUi>
    ) : DiffUtilCallback<IngredientUi>(oldList, newList)

}
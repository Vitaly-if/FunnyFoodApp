package com.example.funnyfood.ui.detail.cookingstep

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.funnyfood.R
import com.example.funnyfood.ui.detail.BaseAdapter
import com.example.funnyfood.ui.detail.DiffUtilCallback
import com.example.funnyfood.ui.detail.ingredient.IngredientUi

class CookingStepAdapter : BaseAdapter<CookingStepUi, CookingStepViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookingStepViewHolder {
        return CookingStepViewHolder(
            R.layout.recipe_item_description_cookingstep.makeView(parent)
        )
    }

    override fun diffUtilCallback(
        list: List<CookingStepUi>,
        data: List<CookingStepUi>
    ): DiffUtil.Callback = CookingStepDiffUtilCallback(list, data)

    inner class CookingStepDiffUtilCallback(
        oldList: List<CookingStepUi>,
        newList: List<CookingStepUi>
    ): DiffUtilCallback<CookingStepUi>(oldList, newList)
}
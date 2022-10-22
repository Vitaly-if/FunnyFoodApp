package com.example.funnyfood.ui.detail.cookingstep

import android.view.View
import com.example.funnyfood.databinding.RecipeItemDescriptionCookingstepBinding
import com.example.funnyfood.ui.detail.BaseViewHolder

class CookingStepViewHolder(view: View) : BaseViewHolder<CookingStepUi>(view) {
    private val binding = RecipeItemDescriptionCookingstepBinding.bind(view)
    override fun bind(item: CookingStepUi) {
        with(binding) {
            item.show(stepIndex,stepName,checkbox,stepTime)
        }
    }
}
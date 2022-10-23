package com.example.funnyfood.ui.detail

import android.R.attr.button
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.example.funnyfood.databinding.FragmentDetailBinding
import com.example.funnyfood.ui.detail.comment.CommentUi
import com.example.funnyfood.ui.detail.cookingstep.CookingStepAdapter
import com.example.funnyfood.ui.detail.cookingstep.CookingStepUi
import com.example.funnyfood.ui.detail.ingredient.IngredientAdapter
import com.example.funnyfood.ui.detail.ingredient.IngredientUi


sealed class RecipeDetailUi {
    open fun show(nameRecipe: TextView, duration: TextView) = Unit
    abstract fun show(
        binding: FragmentDetailBinding, adapter: IngredientAdapter,
        adapterCookingStepAdapter: CookingStepAdapter
    )

    class Base(
        private val id: Int,
        private val name: String,
        private val urlImage: String,
        private val cookingTime: String,
        private val favorite: Boolean,
        private val ingredients: List<IngredientUi>,
        private val cookingSteps: List<CookingStepUi>,
        private val comments: List<CommentUi>
    ) : RecipeDetailUi() {
        override fun show(nameRecipe: TextView, duration: TextView) {
            nameRecipe.text = name
            duration.text = cookingTime
        }

        override fun show(
            binding: FragmentDetailBinding, adapter: IngredientAdapter,
            adapterCookingStepAdapter: CookingStepAdapter
        ) {
            binding.progressRecipeDetail.visibility = View.GONE

            binding.mainLayoutRecipeDetail.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.TOP
            )
            binding.cardRecipeDetail.visibility = View.VISIBLE
            binding.recipeName.text = name
            binding.recipeTimeCocking.text = cookingTime
            binding.recycleIngredient.adapter = adapter
            adapter.map(ingredients)
            binding.recycleCookingSteps.adapter = adapterCookingStepAdapter
            adapterCookingStepAdapter.map(cookingSteps)
        }

    }

    class Fail(private val text: String) : RecipeDetailUi() {
        override fun show(
            binding: FragmentDetailBinding, adapter: IngredientAdapter,
            adapterCookingStepAdapter: CookingStepAdapter
        ) {
            binding.errorMessage.visibility = View.VISIBLE
            binding.errorMessage.text = text
        }
    }

    object Progress : RecipeDetailUi() {
        override fun show(
            binding: FragmentDetailBinding,
            adapterIngredient: IngredientAdapter,
            adapterCookingStepAdapter: CookingStepAdapter
        ) {
            binding.progressRecipeDetail.visibility = View.VISIBLE
        }
    }

}


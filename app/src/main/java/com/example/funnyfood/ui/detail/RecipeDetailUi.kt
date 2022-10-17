package com.example.funnyfood.ui.detail

import android.widget.TextView
import com.example.funnyfood.ui.detail.comment.CommentUi
import com.example.funnyfood.ui.detail.cookingstep.CookingStepUi
import com.example.funnyfood.ui.detail.ingredient.IngredientUi

sealed class RecipeDetailUi {
    open fun show(nameRecipe: TextView, duration: TextView) = Unit
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
    }

    class Fail(private val text: String) : RecipeDetailUi()

    object Progress : RecipeDetailUi()
}

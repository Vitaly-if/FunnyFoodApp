package com.example.funnyfood.ui.detail

import com.example.funnyfood.ui.detail.comment.CommentUi
import com.example.funnyfood.ui.detail.cookingstep.CookingStepUi
import com.example.funnyfood.ui.detail.ingredient.IngredientUi

sealed class RecipeDetailUi {
    class Base(
        private val id: Int,
        private val name: String,
        private val urlImage: String,
        private val cookingTime: String,
        private val favorite: Boolean,
        private val ingredients: List<IngredientUi>,
        private val cookingSteps: List<CookingStepUi>,
        private val comments: List<CommentUi>
    ) : RecipeDetailUi()

    class Fail(private val text: String) : RecipeDetailUi()

    object Progress : RecipeDetailUi()
}

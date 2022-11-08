package com.example.funnyfood.ui.recipes

import android.view.View
import android.widget.ImageView
import com.example.funnyfood.R
import com.example.funnyfood.databinding.RecipeItemErrorBinding
import com.example.funnyfood.databinding.RecipeItemLayoutBinding

sealed class RecipeUi {

    open fun open(recipeListener: RecipesAdapter.RecipeListener) = Unit

    abstract fun show(view: View)

    class Base(
        private val id: Int,
        private val name: String,
        private val urlImage: String,
        private val cookingTime: String,
    ) :
        RecipeUi() {

        override fun show(view: View) {
            val binding = RecipeItemLayoutBinding.bind(view)
            binding.apply {
                nameTextView.text = name
                timeTextView.text = cookingTime
                recipeImageView.setImageResource(R.drawable.rec_img_01)
            }
        }

        override fun open(recipeListener: RecipesAdapter.RecipeListener) {
            recipeListener.showRecipe(id)
        }
    }

    class Fail(private val message: String) : RecipeUi() {
        override fun show(view: View) {
            val binding = RecipeItemErrorBinding.bind(view)
            binding.errorMessage.text = message
        }
    }

    interface TextContainer {

        fun show(text: String)
    }

    interface ImageContainer {

        fun show(url: Int): ImageView

    }
}
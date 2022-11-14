package com.example.funnyfood.ui.recipes

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.funnyfood.R
import com.example.funnyfood.databinding.RecipeItemErrorBinding
import com.example.funnyfood.databinding.RecipeItemLayoutBinding
import com.example.funnyfood.ui.ResourceProvider

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
                println(urlImage)
                recipeImageView.load(urlImage)
            }
        }
        private fun ImageView.load(url: String) {
            Glide.with(this).load(url).error(R.drawable.ic_broken_image).into(this)
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
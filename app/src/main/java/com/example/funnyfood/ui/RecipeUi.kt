package com.example.funnyfood.ui

import android.widget.ImageView
import android.widget.TextView
import com.example.funnyfood.R

sealed class RecipeUi {
    open fun show(
        textContainer: TextView,
        textContainerTwo: TextView,
        imageContainer: ImageContainer
    ) {
    }

    open fun show(text: TextView, textTwo: TextView, image: ImageView) {}


    class Base(
        private val name: String,
        private val timeOfPreparation: String,
        private val urlImage: Int
    ) :
        RecipeUi() {

        override fun show(text: TextView, textTwo: TextView, imageContainer: ImageView) {
            text.text = name
            textTwo.text = timeOfPreparation
            imageContainer.setImageResource(R.drawable.rec_img_01)
        }
    }
    class Fail(private val message: String) : RecipeUi()

    interface TextContainer {

        fun show(text: String)
    }

    interface ImageContainer {

        fun show(url: Int): ImageView

    }
}
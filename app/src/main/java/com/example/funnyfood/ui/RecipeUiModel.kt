package com.example.funnyfood.ui

import android.widget.ImageView
import android.widget.TextView
import com.example.funnyfood.R

interface RecipeUiModel {
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
        RecipeUiModel {

        override fun show(text: TextView, textTwo: TextView, imageContainer: ImageView) {
            text.text = name
            textTwo.text = timeOfPreparation
            imageContainer.setImageResource(R.drawable.rec_img_01)
        }
    }

    interface TextContainer {

        fun show(text: String)
    }

    interface ImageContainer {

        fun show(url: Int): ImageView

    }
}
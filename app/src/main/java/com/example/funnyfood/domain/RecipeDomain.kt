package com.example.funnyfood.domain

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.RecipeUi

sealed class RecipeDomain : Abstract.Object<RecipeUi, RecipeDomainToUiMapper> {

    data class Base(
        private val id: Int,
        private val name: String,
        private val urlImg: String,
        private val cookingTime: String
    ) : RecipeDomain() {
        override fun map(mapper: RecipeDomainToUiMapper): RecipeUi {
            return mapper.map(id, name, urlImg, cookingTime)
        }

    }
}
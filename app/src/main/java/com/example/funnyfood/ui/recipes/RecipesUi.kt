package com.example.funnyfood.ui.recipes

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.RecipesCommunication

sealed class RecipesUi : Abstract.Object<Unit, RecipesCommunication> {
    data class Base(private val recipes: List<RecipeUi>) : RecipesUi() {
        override fun map(mapper: RecipesCommunication) {
            mapper.map(recipes)
        }
    }

}
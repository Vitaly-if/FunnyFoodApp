package com.example.funnyfood.domain

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.RecipesUi

sealed class RecipesDomain: Abstract.Object<RecipesUi, RecipesDomainToUiMapper> {
    data class Success(private val recipes: List<RecipeDomain>) : RecipesDomain() {
        override fun map(mapper: RecipesDomainToUiMapper): RecipesUi {
            return mapper.map(recipes)
        }
    }
    data class Fail(private val errorType: ErrorType) : RecipesDomain() {
        override fun map(mapper: RecipesDomainToUiMapper): RecipesUi {
            return mapper.map(errorType)
        }
    }
}
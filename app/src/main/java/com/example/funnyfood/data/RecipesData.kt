package com.example.funnyfood.data

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.RecipesDomain

sealed class RecipesData : Abstract.Object<RecipesDomain, RecipesDataToDomainMapper> {
    data class Success(private val recipes: List<RecipeData>) : RecipesData() {
        override fun map(mapper: RecipesDataToDomainMapper): RecipesDomain {
            return mapper.map(recipes)
        }
            }
    data class Fail(private val e: Exception) : RecipesData() {
        override fun map(mapper: RecipesDataToDomainMapper): RecipesDomain {
            return mapper.map(e)
        }

    }
}

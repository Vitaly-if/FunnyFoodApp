package com.example.funnyfood.data

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.RecipeDomain
import com.example.funnyfood.domain.RecipesDomain

sealed class RecipesData : Abstract.Object<RecipesDomain, RecipesToDomainMapper> {
    data class Success(private val recipes: List<RecipeData>) : RecipesData() {
        override fun map(mapper: RecipesToDomainMapper): RecipesDomain {
            return mapper.map(recipes)
        }
            }
    data class Fail(private val e: Exception) : RecipesData() {
        override fun map(mapper: RecipesToDomainMapper): RecipesDomain {
            return mapper.map(e)
        }

    }
}

package com.example.funnyfood.data

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.RecipeDomain

sealed class RecipesData : Abstract.Object<RecipeDomain, RecipesToDomainMapper> {
    data class Success(private val recipes: List<RecipeData>) : RecipesData() {
        override fun map(mapper: RecipesToDomainMapper): RecipeDomain {
            return RecipeDomain()//mapper.map(recipes)
        }
            }
    data class Fail(private val e: Exception) : RecipesData() {
        override fun map(mapper: RecipesToDomainMapper): RecipeDomain {
            return RecipeDomain()//mapper.map(e)
        }

    }
}

package com.example.funnyfood.domain

import com.example.funnyfood.data.RecipesRepository
import com.example.funnyfood.data.RecipesToDomainMapper

interface RecipesInteractor {

    suspend fun fetchRecipes(): RecipesDomain

    class Base(private val recipesRepository: RecipesRepository,
    private val mapper: RecipesToDomainMapper
    ): RecipesInteractor {
        override suspend fun fetchRecipes(): RecipesDomain {
            return recipesRepository.fetchRecipes().map(mapper)
        }
    }
}
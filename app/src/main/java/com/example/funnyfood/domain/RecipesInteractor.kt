package com.example.funnyfood.domain

import com.example.funnyfood.data.RecipesRepository
import com.example.funnyfood.data.RecipesDataToDomainMapper

interface RecipesInteractor {

    suspend fun fetchRecipes(): RecipesDomain

    class Base(private val recipesRepository: RecipesRepository,
    private val mapper: RecipesDataToDomainMapper
    ): RecipesInteractor {
        override suspend fun fetchRecipes(): RecipesDomain {
            return recipesRepository.fetchRecipes().map(mapper)
        }
    }
}
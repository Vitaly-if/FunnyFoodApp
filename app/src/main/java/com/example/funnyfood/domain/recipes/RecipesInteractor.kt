package com.example.funnyfood.domain.recipes

import com.example.funnyfood.data.recipes.RecipesRepository
import com.example.funnyfood.data.recipes.RecipesDataToDomainMapper

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
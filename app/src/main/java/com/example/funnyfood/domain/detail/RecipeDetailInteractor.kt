package com.example.funnyfood.domain.detail

import com.example.funnyfood.data.detail.RecipeDetailRepository

interface RecipeDetailInteractor {

    suspend fun fetchRecipeDetail(): RecipeDetailDomain

    class Base(
        private val recipeDetailRepository: RecipeDetailRepository,
        private val mapper: RecipeDetailDataToDomainMapper
    ) : RecipeDetailInteractor {
        override suspend fun fetchRecipeDetail(): RecipeDetailDomain {
            return recipeDetailRepository.fetchRecipeDetail().map(mapper)
        }
    }
}
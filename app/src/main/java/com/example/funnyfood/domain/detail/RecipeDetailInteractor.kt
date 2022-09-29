package com.example.funnyfood.domain.detail

import com.example.funnyfood.data.detail.RecipesDetailDataToDomainMapper
import com.example.funnyfood.data.detail.RecipesDetailRepository

interface RecipesDetailInteractor {

    suspend fun fetchRecipeDetail(): RecipesDetailDomain

    class Base(
        private val recipesDetailRepository: RecipesDetailRepository,
        private val mapper: RecipesDetailDataToDomainMapper
    ) : RecipesDetailInteractor {
        override suspend fun fetchRecipeDetail(): RecipesDetailDomain {
            return recipesDetailRepository.fetchRecipesDetail().map(mapper)
        }
    }
}
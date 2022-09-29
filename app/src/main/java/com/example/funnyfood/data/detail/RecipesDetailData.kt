package com.example.funnyfood.data.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.RecipesDetailDomain

sealed class RecipesDetailData :
    Abstract.Object<RecipesDetailDomain, RecipesDetailDataToDomainMapper> {
    data class Success(private val recipesDetail: List<RecipeDetailData>) : RecipesDetailData() {
        override fun map(mapper: RecipesDetailDataToDomainMapper): RecipesDetailDomain {
            return mapper.map(recipesDetail)
        }
    }
    data class Fail(private val e: Exception) : RecipesDetailData() {
        override fun map(mapper: RecipesDetailDataToDomainMapper): RecipesDetailDomain {
            return mapper.map(e)
        }
    }

}

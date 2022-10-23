package com.example.funnyfood.domain.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.ErrorType
import com.example.funnyfood.ui.detail.RecipesDetailUi

sealed class RecipesDetailDomain :
    Abstract.Object<RecipesDetailUi, RecipesDetailDomainToUiMapper> {
    data class Success(private val recipes: List<RecipeDetailDomain>) : RecipesDetailDomain() {
        override fun map(mapper: RecipesDetailDomainToUiMapper): RecipesDetailUi {
            return mapper.map(recipes)
        }
    }

    data class Fail(private val errorType: ErrorType) : RecipesDetailDomain() {
        override fun map(mapper: RecipesDetailDomainToUiMapper): RecipesDetailUi {
            return mapper.map(errorType)
        }
    }
}

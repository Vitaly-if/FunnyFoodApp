package com.example.funnyfood.domain.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.ErrorType
import com.example.funnyfood.ui.detail.RecipesDetailUi

interface RecipesDetailDomainToUiMapper : Abstract.Mapper {
    fun map(list: List<RecipeDetailDomain>): RecipesDetailUi
    fun map(e: ErrorType): RecipesDetailUi
}
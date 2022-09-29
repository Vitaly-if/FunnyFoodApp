package com.example.funnyfood.domain.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.ErrorType
import com.example.funnyfood.domain.detail.RecipeDetailDomain
import com.example.funnyfood.domain.recipes.RecipeDomain
import com.example.funnyfood.ui.detail.RecipeDetailUi
import com.example.funnyfood.ui.detail.RecipesDetailUi
import com.example.funnyfood.ui.recipes.RecipesUi

interface RecipesDetailDomainToUiMapper<T> : Abstract.Mapper {
    fun map(list: List<RecipeDetailDomain>): RecipesDetailUi
    fun map(e: ErrorType): RecipesDetailUi
}
package com.example.funnyfood.data.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.RecipesDetailDomain

interface RecipesDetailDataToDomainMapper : Abstract.Mapper {
    fun map(listRecipeDetailData: List<RecipeDetailData>) : RecipesDetailDomain
    fun map(e: Exception): RecipesDetailDomain
}
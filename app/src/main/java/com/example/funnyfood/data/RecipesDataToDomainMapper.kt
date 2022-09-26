package com.example.funnyfood.data

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.RecipeDomain
import com.example.funnyfood.domain.RecipesDomain

interface RecipesDataToDomainMapper: Abstract.Mapper {
    fun map(listResipeData: List<RecipeData>): RecipesDomain
    fun map(e: Exception): RecipesDomain
}
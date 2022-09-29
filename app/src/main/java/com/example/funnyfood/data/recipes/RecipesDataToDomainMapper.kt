package com.example.funnyfood.data.recipes

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.recipes.RecipesDomain

interface RecipesDataToDomainMapper: Abstract.Mapper {
    fun map(listResipeData: List<RecipeData>): RecipesDomain
    fun map(e: Exception): RecipesDomain
}
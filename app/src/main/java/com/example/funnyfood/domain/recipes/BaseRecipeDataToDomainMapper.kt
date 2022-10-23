package com.example.funnyfood.domain.recipes

import com.example.funnyfood.data.recipes.RecipeDataToDomainMapper

class BaseRecipeDataToDomainMapper : RecipeDataToDomainMapper {
    override fun map(id: Int, name: String, urlImg: String, cookingTime: String): RecipeDomain {
        return RecipeDomain.Base(id, name, urlImg, cookingTime)
    }
}
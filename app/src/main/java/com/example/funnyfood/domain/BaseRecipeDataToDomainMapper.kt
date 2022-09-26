package com.example.funnyfood.domain

import com.example.funnyfood.data.RecipeData
import com.example.funnyfood.data.RecipeDataToDomainMapper

class BaseRecipeDataToDomainMapper : RecipeDataToDomainMapper {
    override fun map(id: Int, name: String, urlImg: String, cookingTime: String): RecipeDomain {
        return RecipeDomain.Base(id, name, urlImg, cookingTime)
    }
}
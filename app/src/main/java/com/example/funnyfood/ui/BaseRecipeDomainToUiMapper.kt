package com.example.funnyfood.ui

import com.example.funnyfood.domain.RecipeDomainToUiMapper

class BaseRecipeDomainToUiMapper : RecipeDomainToUiMapper {
    override fun map(id: Int, name: String, urlImg: String, cookingTime: String): RecipeUi {
        return RecipeUi.Base(id, name, urlImg, cookingTime)
    }
}
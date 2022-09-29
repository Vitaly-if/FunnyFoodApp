package com.example.funnyfood.data.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.comment.CommentData
import com.example.funnyfood.data.detail.cookingstep.CookingStepData
import com.example.funnyfood.data.detail.ingredient.IngredientData
import com.example.funnyfood.domain.detail.RecipeDetailDomain

interface RecipeDetailDataToDomainMapper : Abstract.Mapper {
    fun map(
        id: Int,
        name: String,
        urlImage: String,
        cookingTime: String,
        favorite: Boolean,
        ingredients: List<IngredientData>,
        cookingSteps: List<CookingStepData>,
        comments: List<CommentData>
    ): RecipeDetailDomain
}
package com.example.funnyfood.domain.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.comment.CommentDomain
import com.example.funnyfood.domain.detail.cookingstep.CookingStepDomain
import com.example.funnyfood.domain.detail.favorite.FavoriteDomain
import com.example.funnyfood.domain.detail.ingredient.IngredientDomain
import com.example.funnyfood.ui.detail.RecipeDetailUi

interface RecipeDetailDomainToUiMapper : Abstract.Mapper {
    fun map(
        id: Int,
        name: String,
        urlImage: String,
        cookingTime: String,
        favorite: List<FavoriteDomain>,
        ingredients: List<IngredientDomain>,
        cookingSteps: List<CookingStepDomain>,
        comments: List<CommentDomain>
    ): RecipeDetailUi
}
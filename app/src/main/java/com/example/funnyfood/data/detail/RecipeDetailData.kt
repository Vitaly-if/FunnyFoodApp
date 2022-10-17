package com.example.funnyfood.data.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.comment.CommentData
import com.example.funnyfood.data.detail.cookingstep.CookingStepData
import com.example.funnyfood.data.detail.favorites.FavoriteData
import com.example.funnyfood.data.detail.ingredient.IngredientData
import com.example.funnyfood.domain.detail.RecipeDetailDomain

data class RecipeDetailData(
    private val id: Int,
    private val name: String,
    private val urlImage: String,
    private val cookingTime: String,
    private val favorite: List<FavoriteData>,
    private val ingredients: List<IngredientData>,
    private val cookingSteps: List<CookingStepData>,
    private val comments: List<CommentData>
) : Abstract.Object<RecipeDetailDomain, RecipeDetailDataToDomainMapper> {
    override fun map(mapper: RecipeDetailDataToDomainMapper) : RecipeDetailDomain {
        return mapper.map(id, name, urlImage, cookingTime, favorite,
            ingredients, cookingSteps, comments
        )
    }
}

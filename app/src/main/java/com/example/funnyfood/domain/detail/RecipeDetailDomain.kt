package com.example.funnyfood.domain.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.comment.CommentDomain
import com.example.funnyfood.domain.detail.cookingstep.CookingStepDomain
import com.example.funnyfood.domain.detail.ingredient.IngredientDomain
import com.example.funnyfood.ui.detail.RecipeDetailUi

data class RecipeDetailDomain(
    private val id: Int,
    private val name: String,
    private val urlImage: String,
    private val cookingTime: String,
    private val favorite: Boolean,
    private val ingredients: List<IngredientDomain>,
    private val cookingSteps: List<CookingStepDomain>,
    private val comments: List<CommentDomain>
) : Abstract.Object<RecipeDetailUi, RecipeDetailDomainToUiMapper> {
    override fun map(mapper: RecipeDetailDomainToUiMapper) : RecipeDetailUi {
        return mapper.map(id, name, urlImage, cookingTime, favorite,
            ingredients, cookingSteps, comments
        )
    }
}

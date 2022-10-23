package com.example.funnyfood.ui.detail

import com.example.funnyfood.domain.detail.cookingstep.CookingStepDomain
import com.example.funnyfood.domain.detail.ingredient.IngredientDomain
import com.example.funnyfood.domain.detail.RecipeDetailDomainToUiMapper
import com.example.funnyfood.domain.detail.comment.CommentDomain
import com.example.funnyfood.domain.detail.favorite.FavoriteDomain
import com.example.funnyfood.domain.detail.favorite.FavoriteDomainToUiMapper
import com.example.funnyfood.domain.detail.favorite.FavoritesDomainToUiMapper
import com.example.funnyfood.ui.detail.comment.BaseCommentDomainToUiMapper
import com.example.funnyfood.ui.detail.comment.BaseCommentsDomainToUiMapper
import com.example.funnyfood.ui.detail.cookingstep.BaseCookingStepDomainToUiMapper
import com.example.funnyfood.ui.detail.cookingstep.BaseCookingStepsDomainToUiMapper
import com.example.funnyfood.ui.detail.ingredient.BaseIngredientDomainToUiMapper
import com.example.funnyfood.ui.detail.ingredient.BaseIngredientsDomainToUiMapper

class BaseRecipeDetailDomainToUiMapper : RecipeDetailDomainToUiMapper {

    override fun map(
        id: Int,
        name: String,
        urlImage: String,
        cookingTime: String,
        favorite: List<FavoriteDomain>,
        ingredients: List<IngredientDomain>,
        cookingSteps: List<CookingStepDomain>,
        comments: List<CommentDomain>
    ): RecipeDetailUi {
        val baseIngredientDomainToUiMapper = BaseIngredientDomainToUiMapper()
        val baseIngredientsDomainToUiMapper =
            BaseIngredientsDomainToUiMapper(baseIngredientDomainToUiMapper)
        val baseCommentDomainToUiMapper = BaseCommentDomainToUiMapper()
        val baseCommentsDomainToUiMapper = BaseCommentsDomainToUiMapper(baseCommentDomainToUiMapper)
        val baseCookingStepDomainToUiMapper = BaseCookingStepDomainToUiMapper()
        val baseCookingStepsDomainToUiMapper = BaseCookingStepsDomainToUiMapper(baseCookingStepDomainToUiMapper)
        val baseFavoriteDomainToUiMapper = FavoriteDomainToUiMapper.Base("UserLogin")//todo fix login user
        val baseFavoritesDomainToUiMapper = FavoritesDomainToUiMapper.Base(baseFavoriteDomainToUiMapper)
        return RecipeDetailUi.Base(
            id, name, urlImage, cookingTime,
            baseFavoritesDomainToUiMapper.map(favorite), baseIngredientsDomainToUiMapper.map(ingredients),
            baseCookingStepsDomainToUiMapper.map(cookingSteps),
        baseCommentsDomainToUiMapper.map(comments)
        )
    }
}
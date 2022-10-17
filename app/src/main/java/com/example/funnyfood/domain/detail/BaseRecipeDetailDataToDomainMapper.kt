package com.example.funnyfood.domain.detail

import com.example.funnyfood.data.detail.RecipeDetailDataToDomainMapper
import com.example.funnyfood.data.detail.comment.CommentData
import com.example.funnyfood.data.detail.cookingstep.CookingStepData
import com.example.funnyfood.data.detail.favorites.FavoriteData
import com.example.funnyfood.data.detail.favorites.FavoriteDataToDomain
import com.example.funnyfood.data.detail.favorites.FavoritesDataToDomain
import com.example.funnyfood.data.detail.ingredient.IngredientData
import com.example.funnyfood.domain.detail.comment.BaseCommentDataToDomainMapper
import com.example.funnyfood.domain.detail.comment.BaseCommentsDataToDomainMapper
import com.example.funnyfood.domain.detail.cookingstep.BaseCookingStepDataToDomainMapper
import com.example.funnyfood.domain.detail.cookingstep.BaseCookingStepsDataToDomainMapper
import com.example.funnyfood.domain.detail.ingredient.BaseIngredientDataToDomainMapper
import com.example.funnyfood.domain.detail.ingredient.BaseIngredientsDataToDomainMapper

class BaseRecipeDetailDataToDomainMapper : RecipeDetailDataToDomainMapper {
    override fun map(
        id: Int,
        name: String,
        urlImage: String,
        cookingTime: String,
        favorite: List<FavoriteData>,
        ingredients: List<IngredientData>,
        cookingSteps: List<CookingStepData>,
        comments: List<CommentData>
    ): RecipeDetailDomain {
        val baseIngredientDataToDomainMapper = BaseIngredientDataToDomainMapper()
        val baseIngredientsDataToDomainMapper =
            BaseIngredientsDataToDomainMapper(baseIngredientDataToDomainMapper)
        val baseCommentDataToDomainMapper = BaseCommentDataToDomainMapper()
        val baseCommentsDataToDomainMapper =
            BaseCommentsDataToDomainMapper(baseCommentDataToDomainMapper)
        val baseCookingStepDataToDomainMapper = BaseCookingStepDataToDomainMapper()
        val baseCookingStepsDataToDomainMapper =
            BaseCookingStepsDataToDomainMapper(baseCookingStepDataToDomainMapper)
        val baseFavoriteDataToDomainMapper = FavoriteDataToDomain.Base()
        val baseFavoritesDataToDomainMapper =
            FavoritesDataToDomain.Base(baseFavoriteDataToDomainMapper)
        return RecipeDetailDomain(
            id,
            name,
            urlImage,
            cookingTime,
            baseFavoritesDataToDomainMapper.map(favorite),
            baseIngredientsDataToDomainMapper.map(ingredients),
            baseCookingStepsDataToDomainMapper.map(cookingSteps),
            baseCommentsDataToDomainMapper.map(comments)
        )
    }
}
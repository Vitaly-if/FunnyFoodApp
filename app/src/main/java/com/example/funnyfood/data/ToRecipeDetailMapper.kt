package com.example.funnyfood.data

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.core.Read
import com.example.funnyfood.data.detail.RecipeDetailData
import com.example.funnyfood.data.detail.cloud.RecipeDetailDTO
import com.example.funnyfood.data.detail.cloud.comment.CommentCloudToDataMapper
import com.example.funnyfood.data.detail.cloud.comment.CommentDTO
import com.example.funnyfood.data.detail.cloud.comment.CommentsCloudToDataMapper
import com.example.funnyfood.data.detail.cloud.cookingstep.CookingStepCloudToDataMapper
import com.example.funnyfood.data.detail.cloud.cookingstep.CookingStepDTO
import com.example.funnyfood.data.detail.cloud.cookingstep.CookingStepsCloudToDataMapper
import com.example.funnyfood.data.detail.cloud.favorites.FavoriteCloudToDataMapper
import com.example.funnyfood.data.detail.cloud.favorites.FavoriteDTO
import com.example.funnyfood.data.detail.cloud.favorites.FavoritesCloudToDataMapper
import com.example.funnyfood.data.detail.cloud.ingredient.IngredientCloudToDataMapper
import com.example.funnyfood.data.detail.cloud.ingredient.IngredientDTO
import com.example.funnyfood.data.detail.cloud.ingredient.IngredientsCloudToDataMapper
import com.example.funnyfood.data.detail.comment.CommentData
import com.example.funnyfood.data.detail.cookingstep.CookingStepData
import com.example.funnyfood.data.detail.favorites.FavoriteData
import com.example.funnyfood.data.detail.ingredient.IngredientData

interface ToRecipeDetailMapper : Abstract.Mapper {
    fun map(
        id: Int,
        name: String,
        urlImage: String,
        cookingTime: String,
        favorite: List<FavoriteDTO>,
        ingredients: List<IngredientDTO>,
        cookingSteps: List<CookingStepDTO>,
        comments: List<CommentDTO>
    ): RecipeDetailData

    class Base : ToRecipeDetailMapper {
        override fun map(
            id: Int,
            name: String,
            urlImage: String,
            cookingTime: String,
            favorite: List<FavoriteDTO>,
            ingredients: List<IngredientDTO>,
            cookingSteps: List<CookingStepDTO>,
            comments: List<CommentDTO>
        ): RecipeDetailData {
            val baseFavoriteCloudToDataMapper = FavoriteCloudToDataMapper.Base()
            val baseFavoritesCloudToDataMapper =
                FavoritesCloudToDataMapper.Base(baseFavoriteCloudToDataMapper)
            val baseCommentCloudToDataMapper = CommentCloudToDataMapper.Base()
            val baseCommentsCloudToDataMapper =
                CommentsCloudToDataMapper.Base(baseCommentCloudToDataMapper)
            val baseCookingStepCloudToDataMapper = CookingStepCloudToDataMapper.Base()
            val baseCookingStepsCloudToDataMapper =
                CookingStepsCloudToDataMapper.Base(baseCookingStepCloudToDataMapper)
            val baseIngredientCloudToDataMapper = IngredientCloudToDataMapper.Base()
            val baseIngredientsCloudToDataMapper =
                IngredientsCloudToDataMapper.Base(baseIngredientCloudToDataMapper)

            return RecipeDetailData(
                id,
                name,
                urlImage,
                cookingTime,
                baseFavoritesCloudToDataMapper.map(favorite),
                baseIngredientsCloudToDataMapper.map(ingredients),
                baseCookingStepsCloudToDataMapper.map(cookingSteps),
                baseCommentsCloudToDataMapper.map(comments)
            )

        }
    }
}
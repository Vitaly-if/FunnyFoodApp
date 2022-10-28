package com.example.funnyfood.data.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.ToRecipeDetailMapper
import com.example.funnyfood.data.detail.cache.CommentDB
import com.example.funnyfood.data.detail.cache.CookingStepDB
import com.example.funnyfood.data.detail.cache.FavoriteDB
import com.example.funnyfood.data.detail.cache.IngredientDB
import com.example.funnyfood.data.detail.cloud.comment.CommentDTO
import com.example.funnyfood.data.detail.cloud.cookingstep.CookingStepDTO
import com.example.funnyfood.data.detail.cloud.favorites.FavoriteDTO
import com.example.funnyfood.data.detail.cloud.ingredient.IngredientDTO

interface ToRecipeDetailDataMapper : Abstract.Mapper {
    fun map(
        id: Int,
        name: String,
        cookingTime: String,
        favoritesDB: List<FavoriteDB>,
        ingredientsDB: List<IngredientDB>,
        cookingStepsDB: List<CookingStepDB>,
        commentsDB: List<CommentDB>,
        imageUrl: String
    ): RecipeDetailData

    class Base : ToRecipeDetailDataMapper {
        override fun map(
            id: Int,
            name: String,
            cookingTime: String,
            favoritesDB: List<FavoriteDB>,
            ingredientsDB: List<IngredientDB>,
            cookingStepsDB: List<CookingStepDB>,
            commentsDB: List<CommentDB>,
            imageUrl: String
        ): RecipeDetailData {
            return RecipeDetailData(
                id, name, cookingTime, cookingTime, listOf(), listOf(), listOf(), listOf()
            )
        }
    }
}
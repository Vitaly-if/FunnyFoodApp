package com.example.funnyfood.data.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.comments.CommentDB
import com.example.funnyfood.data.detail.cache.comments.CommentDBToDataMapper
import com.example.funnyfood.data.detail.cache.comments.CommentsDBToDataMapper
import com.example.funnyfood.data.detail.cache.cookingsteps.CookingStepDB
import com.example.funnyfood.data.detail.cache.cookingsteps.CookingStepDBToDataMapper
import com.example.funnyfood.data.detail.cache.cookingsteps.CookingStepsDBToDataMapper
import com.example.funnyfood.data.detail.cache.favorites.FavoriteDB
import com.example.funnyfood.data.detail.cache.ingredients.IngredientDB
import com.example.funnyfood.data.detail.cache.favorites.FavoriteDBToData
import com.example.funnyfood.data.detail.cache.favorites.FavoritesDBToData
import com.example.funnyfood.data.detail.cache.ingredients.IngredientDBTOData
import com.example.funnyfood.data.detail.cache.ingredients.IngredientsDBToData

interface ToRecipeDetailDataMapper : Abstract.Mapper {
    fun map(
        id: Int,
        name: String,
        cookingTime: String,
        favoritesDB: List<FavoriteDB>,
        ingredientsDB: List<IngredientDB>,
        cookingStepsDB: List<CookingStepDB>,
        commentsDB: List<CommentDB>,
        imageUrl: String,
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
            imageUrl: String,
        ): RecipeDetailData {
            val favoriteDBToData = FavoriteDBToData.Base()
            val favoritesDBToData = FavoritesDBToData.Base(favoriteDBToData)
            val ingredientDBToData = IngredientDBTOData.Base()
            val ingredientsDBToData = IngredientsDBToData.Base(ingredientDBToData)
            val cookingStepDBToData = CookingStepDBToDataMapper.Base()
            val cookingStepsDbToData = CookingStepsDBToDataMapper.Base(cookingStepDBToData)
            val commentDbToData = CommentDBToDataMapper.Base()
            val commentsDbToData = CommentsDBToDataMapper.Base(commentDbToData)
            return RecipeDetailData(
                id, name, imageUrl, cookingTime, favoritesDBToData.map(favoritesDB),
                ingredientsDBToData.map(ingredientsDB), cookingStepsDbToData.map(cookingStepsDB),
                commentsDbToData.map(commentsDB)
            )
        }
    }
}
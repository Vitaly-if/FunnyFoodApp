package com.example.funnyfood.data.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.*
import com.example.funnyfood.data.detail.comment.CommentData
import com.example.funnyfood.data.detail.comment.CommentDataToDBMapper
import com.example.funnyfood.data.detail.comment.CommentsDataToDBMapper
import com.example.funnyfood.data.detail.cookingstep.CookingStepData
import com.example.funnyfood.data.detail.cookingstep.CookingStepDataToDBMapper
import com.example.funnyfood.data.detail.cookingstep.CookingStepsDataToDBMapper
import com.example.funnyfood.data.detail.favorites.FavoriteData
import com.example.funnyfood.data.detail.favorites.FavoriteDataToDb
import com.example.funnyfood.data.detail.favorites.FavoritesDataToDb
import com.example.funnyfood.data.detail.ingredient.IngredientData
import com.example.funnyfood.data.detail.ingredient.IngredientDataToDBMapper
import com.example.funnyfood.data.detail.ingredient.IngredientsDataToDbMapper

interface RecipeDetailDataToDbMapper : Abstract.Mapper {

    fun mapBy(
        id: Int,
        name: String,
        urlImage: String,
        cookingTime: String,
        favorite: List<FavoriteData>,
        ingredients: List<IngredientData>,
        cookingSteps: List<CookingStepData>,
        comments: List<CommentData>,
    ): RecipeDetailDB

    class Base : RecipeDetailDataToDbMapper {
        override fun mapBy(
            id: Int,
            name: String,
            urlImage: String,
            cookingTime: String,
            favorite: List<FavoriteData>,
            ingredients: List<IngredientData>,
            cookingSteps: List<CookingStepData>,
            comments: List<CommentData>,
        ): RecipeDetailDB {
            val favoriteDataToDb = FavoriteDataToDb.Base()
            val favoritesDataToDb = FavoritesDataToDb.Base(favoriteDataToDb)
            val ingredientDataToDb = IngredientDataToDBMapper.Base()
            val ingredientsDataToDb = IngredientsDataToDbMapper.Base(ingredientDataToDb)
            val cookingStepDataToDB = CookingStepDataToDBMapper.Base()
            val cookingStepsDataToDB = CookingStepsDataToDBMapper.Base(cookingStepDataToDB)
            val commentDataToDB = CommentDataToDBMapper.Base()
            val commentsDataToDB =CommentsDataToDBMapper.Base(commentDataToDB)
            val recipeDetailDB = RecipeDetailDB()
            recipeDetailDB.id = id
            recipeDetailDB.name = name
            recipeDetailDB.cookingTime = cookingTime
            recipeDetailDB.favoritesDB = favoritesDataToDb.map(favorite)
            recipeDetailDB.ingredientsDB = ingredientsDataToDb.map(ingredients)
            recipeDetailDB.cookingStepsDB = cookingStepsDataToDB.map(cookingSteps)
            recipeDetailDB.commentsDB = commentsDataToDB.map(comments)
            recipeDetailDB.imageUrl = urlImage
            return recipeDetailDB
        }
    }
}
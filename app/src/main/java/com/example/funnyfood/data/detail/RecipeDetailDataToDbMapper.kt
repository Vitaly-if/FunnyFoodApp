package com.example.funnyfood.data.detail

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.core.DbWrapper
import com.example.funnyfood.data.detail.cache.*
import com.example.funnyfood.data.detail.comment.CommentData
import com.example.funnyfood.data.detail.cookingstep.CookingStepData
import com.example.funnyfood.data.detail.favorites.FavoriteData
import com.example.funnyfood.data.detail.ingredient.IngredientData
import io.realm.RealmList

interface RecipeDetailDataToDbMapper : Abstract.Mapper {

    fun mapToDb(
        id: Int,
        name: String,
        urlImage: String,
        cookingTime: String,
        favorite: List<FavoriteData>,
        ingredients: List<IngredientData>,
        cookingSteps: List<CookingStepData>,
        comments: List<CommentData>,
        db: DbWrapper<RecipeDetailDB>
    ): RecipeDetailDB

    class Base() : RecipeDetailDataToDbMapper {
        override fun mapToDb(
            id: Int,
            name: String,
            urlImage: String,
            cookingTime: String,
            favorite: List<FavoriteData>,
            ingredients: List<IngredientData>,
            cookingSteps: List<CookingStepData>,
            comments: List<CommentData>,
            db: DbWrapper<RecipeDetailDB>
        ): RecipeDetailDB {
            val recipeDetailDB = db.createObject(id*1000+id)
            recipeDetailDB.cookingTime = "data in base"
            recipeDetailDB.favoritesDB = RealmList()
            recipeDetailDB.ingredientsDB = RealmList()
            recipeDetailDB.cookingStepsDB = RealmList()
            recipeDetailDB.commentsDB = RealmList()
            recipeDetailDB.imageUrl = ""
            return recipeDetailDB
        }
    }
}
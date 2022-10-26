package com.example.funnyfood.data.detail.cache

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.ToRecipeDetailMapper
import com.example.funnyfood.data.detail.RecipeDetailData
import com.example.funnyfood.data.detail.cloud.comment.CommentDTO
import com.example.funnyfood.data.detail.cloud.cookingstep.CookingStepDTO
import com.example.funnyfood.data.detail.cloud.favorites.FavoriteDTO
import com.example.funnyfood.data.detail.cloud.ingredient.IngredientDTO
import com.example.funnyfood.data.recipes.ToRecipeDataMapper
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RecipeDetailDB : RealmObject(), RecipeDetailRealm,
    Abstract.Object<RecipeDetailData, ToRecipeDataMapper> {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""
    var cookingTime: String = ""
    var favoritesDB: List<FavoriteDB>
    var ingredientsDB: List<IngredientDB>
    var cookingStepsDB: List<CookingStepDB>
    var commentsDB: List<CommentDB>
    var imageUrl: String = ""

    override fun map(mapper: ToRecipeDataMapper): RecipeDetailData {
        return mapper.map(
            id, name, imageUrl, cookingTime, favoritesDB, ingredientsDB,
            cookingStepsDB, commentsDB
        )
    }
}
interface RecipeDetailRealm {
    fun map(mapper: ToRecipeDetailDataMapper): RecipeDetailData
}

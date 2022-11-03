package com.example.funnyfood.data.detail.cache

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.RecipeDetailData
import com.example.funnyfood.data.detail.ToRecipeDetailDataMapper
import com.example.funnyfood.data.detail.cache.comments.CommentDB
import com.example.funnyfood.data.detail.cache.cookingsteps.CookingStepDB
import com.example.funnyfood.data.detail.cache.favorites.FavoriteDB
import com.example.funnyfood.data.detail.cache.ingredients.IngredientDB
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.realmListOf

open class RecipeDetailDB : RealmObject, RecipeDetailRealm,
    Abstract.Object<RecipeDetailData, ToRecipeDetailDataMapper> {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""
    var cookingTime: String = ""
    var favoritesDB: RealmList<FavoriteDB> = realmListOf()
    var ingredientsDB: RealmList<IngredientDB> = realmListOf()
    var cookingStepsDB: RealmList<CookingStepDB> = realmListOf()
    var commentsDB: RealmList<CommentDB> = realmListOf()
    var imageUrl: String = ""

    override fun map(mapper: ToRecipeDetailDataMapper): RecipeDetailData {
        return mapper.map(
            id, name, cookingTime, favoritesDB, ingredientsDB,
            cookingStepsDB, commentsDB, imageUrl
        )
    }
}

interface RecipeDetailRealm {
    fun map(mapper: ToRecipeDetailDataMapper): RecipeDetailData
}

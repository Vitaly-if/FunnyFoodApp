package com.example.funnyfood.data.recipes.cache

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.recipes.RecipeData
import com.example.funnyfood.data.recipes.ToRecipeDataMapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RecipeDB: RealmObject(), RecipeRealm, Abstract.Object<RecipeData, ToRecipeDataMapper> {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""
    var urlImg: String = ""
    var cookingTime: String = ""

    override fun map(mapper: ToRecipeDataMapper) = RecipeData(id, name, urlImg, cookingTime)
}
interface RecipeRealm {
    fun map(mapper: ToRecipeDataMapper): RecipeData
}

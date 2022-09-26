package com.example.funnyfood.data.cache

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.RecipeData
import com.example.funnyfood.data.ToRecipeDataMapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

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

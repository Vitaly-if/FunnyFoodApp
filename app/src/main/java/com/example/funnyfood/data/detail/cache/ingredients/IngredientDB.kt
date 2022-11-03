package com.example.funnyfood.data.detail.cache.ingredients

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.ingredient.IngredientData
import io.realm.RealmObject

open class IngredientDB : RealmObject, Abstract.Object<IngredientData, IngredientDBTOData> {

    var name: String = ""
    var quantity: String = ""
    var unit: String = ""
    override fun map(mapper: IngredientDBTOData): IngredientData {
        return mapper.map(name, quantity, unit)
    }

}
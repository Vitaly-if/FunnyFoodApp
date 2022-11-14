package com.example.funnyfood.data.detail.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.ingredients.IngredientDB
import io.realm.RealmList
import io.realm.realmListOf

interface IngredientsDataToDbMapper : Abstract.Mapper {
    fun map(list: List<IngredientData>): RealmList<IngredientDB>
    class Base(private val mapper: IngredientDataToDBMapper) : IngredientsDataToDbMapper {
        override fun map(list: List<IngredientData>): RealmList<IngredientDB> {
            val listRealm: RealmList<IngredientDB> = realmListOf()
            list.forEach {
                listRealm.add(it.mapBy(mapper))
            }
            return listRealm
        }
    }
}
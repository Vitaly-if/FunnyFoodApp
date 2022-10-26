package com.example.funnyfood.data.detail.cache

import io.realm.RealmObject

open class IngredientDB : RealmObject() {
    var name: String = ""
    var quantity: String = ""
    var unit: String = ""
}
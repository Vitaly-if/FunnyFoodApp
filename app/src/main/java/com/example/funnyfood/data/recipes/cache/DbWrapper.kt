package com.example.funnyfood.data.recipes.cache

import io.realm.Realm

interface DbWrapper {

    fun createObject(id: Int): RecipeDB

    class Base(private val realm: Realm): DbWrapper {
        override fun createObject(id: Int): RecipeDB {
            return realm.createObject(RecipeDB::class.java, id)
        }
    }
}
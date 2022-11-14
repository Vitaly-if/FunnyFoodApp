package com.example.funnyfood.data.recipes.cache

import com.example.funnyfood.core.RealmProvider
import com.example.funnyfood.data.recipes.RecipeData
import com.example.funnyfood.data.recipes.RecipeDataToDbMapper
import io.realm.query

interface RecipesCacheDataSource {

    fun fetchRecipes(): List<RecipeDB>
    fun saveRecipes(recipes: List<RecipeData>)

    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: RecipeDataToDbMapper,
    ) : RecipesCacheDataSource {

        override fun fetchRecipes(): List<RecipeDB> {
            return realmProvider.provider().query<RecipeDB>().find().toList()
        }

        override fun saveRecipes(recipes: List<RecipeData>) {
            realmProvider.provider().writeBlocking {
                recipes.forEach { recipe ->
                    copyToRealm(recipe.mapBy(mapper))
                }
            }
        }
    }
}



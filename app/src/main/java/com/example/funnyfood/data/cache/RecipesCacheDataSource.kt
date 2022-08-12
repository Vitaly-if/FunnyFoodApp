package com.example.funnyfood.data.cache

import com.example.funnyfood.data.RecipeData
import com.example.funnyfood.data.RecipeDataToDbMapper

interface RecipesCacheDataSource {

    fun fetchRecipes(): List<RecipeDB>

    fun saveRecipes(recipes: List<RecipeData>)

    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: RecipeDataToDbMapper
    ) : RecipesCacheDataSource {

        override fun fetchRecipes(): List<RecipeDB> {
            realmProvider.provider().use { realm ->
                val recipeDb = realm.where(RecipeDB::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(recipeDb)

            }
        }

        override fun saveRecipes(recipes: List<RecipeData>) =
            realmProvider.provider().use { realm ->
                realm.executeTransaction {
                    recipes.forEach { recipe ->
                        recipe.mapTo(mapper, DbWrapper.Base(it))

                    }
                }
            }

    }


}
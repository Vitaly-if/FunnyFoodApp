package com.example.funnyfood.data.detail.cache

import com.example.funnyfood.core.DbWrapper
import com.example.funnyfood.core.RealmProvider
import com.example.funnyfood.data.detail.RecipeDetailData
import com.example.funnyfood.data.detail.RecipeDetailDataToDbMapper
import io.realm.Realm

interface RecipesDetailCacheDataSource {

    fun fetchDetailRecipes(): List<RecipeDetailDB>

    fun saveDetailRecipes(recipes: List<RecipeDetailData>)

    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: RecipeDetailDataToDbMapper
    ) : RecipesDetailCacheDataSource {
        override fun fetchDetailRecipes(): List<RecipeDetailDB> {
            realmProvider.provider().use { realm ->
                val recipeDetailDB =
                    realm.where(RecipeDetailDB::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(recipeDetailDB)
            }
        }

        override fun saveDetailRecipes(recipes: List<RecipeDetailData>) =
            realmProvider.provider().use { realm ->
                realm.executeTransaction {
                    recipes.forEach { recipe ->
                        recipe.mapBy(mapper, RecipeDetailDbWrapper(realm))
                    }
                }

            }

        private inner class RecipeDetailDbWrapper(realm: Realm) :
            DbWrapper.Base<RecipeDetailDB>(realm) {
            override fun dbClass(): Class<RecipeDetailDB> = RecipeDetailDB::class.java
        }
    }
}
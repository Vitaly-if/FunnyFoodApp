package com.example.funnyfood.data.detail.cache

import com.example.funnyfood.core.RealmProvider
import com.example.funnyfood.data.detail.RecipeDetailData
import com.example.funnyfood.data.detail.RecipeDetailDataToDbMapper
import io.realm.query

interface RecipesDetailCacheDataSource {

    fun fetchDetailRecipes(): List<RecipeDetailDB>

    fun saveDetailRecipes(recipes: List<RecipeDetailData>)

    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: RecipeDetailDataToDbMapper,
    ) : RecipesDetailCacheDataSource {

        override fun fetchDetailRecipes(): List<RecipeDetailDB> {
            return realmProvider.provider().query<RecipeDetailDB>().find()
        }

        override fun saveDetailRecipes(recipes: List<RecipeDetailData>) {
            realmProvider.provider().writeBlocking {
                recipes.forEach { recipe ->
                    copyToRealm(recipe.mapBy(mapper))
                }
            }
        }
    }
}
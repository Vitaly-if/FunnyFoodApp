package com.example.funnyfood.core

import com.example.funnyfood.data.detail.cache.comments.CommentDB
import com.example.funnyfood.data.detail.cache.RecipeDetailDB
import com.example.funnyfood.data.detail.cache.cookingsteps.CookingStepDB
import com.example.funnyfood.data.detail.cache.favorites.FavoriteDB
import com.example.funnyfood.data.detail.cache.ingredients.IngredientDB
import com.example.funnyfood.data.recipes.cache.RecipeDB
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import io.realm.migration.AutomaticSchemaMigration

interface RealmProvider {

    fun provider(): Realm

    class Base : RealmProvider {

        override fun provider(): Realm {
            val conf = RealmConfiguration.Builder(schema = REALM_SET)
                .schemaVersion(SCHEMA_VERSION)
                .migration(MIGRATION)
                .build()
            return Realm.open(conf)
        }

        private companion object {
            val REALM_SET = setOf(
                RecipeDB::class,
                RecipeDetailDB::class,
                FavoriteDB::class,
                CommentDB::class,
                IngredientDB::class,
                CookingStepDB::class
            )
            const val SCHEMA_VERSION = 1L
            val MIGRATION = AutomaticSchemaMigration {
                it.enumerate(
                    className = "RecipeRealm",
                    block = { _, newObject ->
                        newObject?.run {
                            set(
                                propertyName = "labelForSearch",
                                value = String()
                            )
                            set(
                                propertyName = "primaryKey",
                                value = String()
                            )
                        }
                    }
                )
            }
        }

    }
}
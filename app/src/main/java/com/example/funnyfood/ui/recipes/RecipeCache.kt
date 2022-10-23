package com.example.funnyfood.ui.recipes

import com.example.funnyfood.core.PreferencesProvider
import com.example.funnyfood.core.Read
import com.example.funnyfood.core.Save

interface RecipeCache : Save<Int> , Read<Int> {

    class Base(preferencesProvider: PreferencesProvider) : RecipeCache {
        private val sharedPreferences =
            preferencesProvider.provideSharedPreferences(RECIPE_ID_FILENAME)

        override fun read() =
            sharedPreferences.getInt(RECIPE_KEY, 0)

        override fun save(data: Int) =
            sharedPreferences.edit()
                .putInt(RECIPE_KEY, data)
                .apply()

        private companion object {
            const val RECIPE_ID_FILENAME = "recipeId"
            const val RECIPE_KEY = "recipeIdKey"
        }
    }
}
package com.example.funnyfood.core

import android.app.Application
import com.example.funnyfood.sl.core.CoreModule
import com.example.funnyfood.sl.detail.RecipeDetailModule
import com.example.funnyfood.sl.detail.RecipesDetailFactory
import com.example.funnyfood.sl.recipes.RecipesFactory
import com.example.funnyfood.sl.recipes.RecipesModule

class FunnyFoodApp : Application() {

    private val coreModule = CoreModule()

    override fun onCreate() {
        super.onCreate()

        coreModule.init(this)

    }

    fun getMainViewModel() = coreModule.getViewModel()
    fun recipesFactory() = RecipesFactory(RecipesModule(coreModule))
    fun recipeDetailFactory() = RecipesDetailFactory(RecipeDetailModule(coreModule))
}

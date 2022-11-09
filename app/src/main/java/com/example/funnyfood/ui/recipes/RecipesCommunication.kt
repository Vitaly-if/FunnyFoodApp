package com.example.funnyfood.ui.recipes

import com.example.funnyfood.core.Communication

interface RecipesCommunication : Communication<List<RecipeUi>> {
    class Base : Communication.Base<List<RecipeUi>>(), RecipesCommunication
}
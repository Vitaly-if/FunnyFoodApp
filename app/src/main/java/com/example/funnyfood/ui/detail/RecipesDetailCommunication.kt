package com.example.funnyfood.ui.detail

import com.example.funnyfood.core.Communication

interface RecipesDetailCommunication : Communication<List<RecipeDetailUi>> {
    class Base : Communication.Base<List<RecipeDetailUi>>(), RecipesDetailCommunication
}

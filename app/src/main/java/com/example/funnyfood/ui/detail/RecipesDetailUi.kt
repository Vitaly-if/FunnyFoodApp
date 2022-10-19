package com.example.funnyfood.ui.detail

import com.example.funnyfood.core.Abstract

data class RecipesDetailUi(
    private val list: List<RecipeDetailUi>
) : Abstract.Object<Unit, RecipesDetailCommunication> {
    override fun map(mapper: RecipesDetailCommunication) = mapper.map(list)

}

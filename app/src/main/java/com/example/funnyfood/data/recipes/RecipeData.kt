package com.example.funnyfood.data.recipes

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.recipes.cache.RecipeDB
import com.example.funnyfood.domain.recipes.RecipeDomain

data class RecipeData(
    private val id: Int,
    private val name: String,
    private val urlImg: String,
    private val cookingTime: String
) : Abstract.Mapper.ToDb<RecipeDB, RecipeDataToDbMapper>,
    Abstract.Object<RecipeDomain, RecipeDataToDomainMapper> {

    override fun map(mapper: RecipeDataToDomainMapper): RecipeDomain {
        return mapper.map(id, name, urlImg, cookingTime)
    }

    override fun mapBy(mapper: RecipeDataToDbMapper): RecipeDB {
        return mapper.mapBy(id, name, urlImg, cookingTime)
    }
}

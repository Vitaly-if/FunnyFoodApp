package com.example.funnyfood.data

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.cache.DbWrapper
import com.example.funnyfood.data.cache.RecipeDB
import com.example.funnyfood.domain.RecipeDomain

data class RecipeData(
    private val id: Int,
    private val name: String,
    private val urlImg: String,
    private val cookingTime: String
) : ToRecipeDb<RecipeDB, RecipeDataToDbMapper>,
    Abstract.Object<RecipeDomain, RecipeDataToDomainMapper> {
    override fun map(mapper: RecipeDataToDomainMapper): RecipeDomain {
        return mapper.map(id, name, urlImg, cookingTime)
    }

    override fun mapTo(mapper: RecipeDataToDbMapper, db: DbWrapper): RecipeDB {
        return mapper.mapToDb(id, name, urlImg, cookingTime, db)
    }
}

interface ToRecipeDb<T, M : Abstract.Mapper> {
    fun mapTo(mapper: M, db: DbWrapper): T
}
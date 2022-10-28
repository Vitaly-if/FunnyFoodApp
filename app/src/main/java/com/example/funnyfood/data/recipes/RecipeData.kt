package com.example.funnyfood.data.recipes

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.core.DbWrapper
import com.example.funnyfood.data.recipes.cache.RecipeDB
import com.example.funnyfood.domain.recipes.RecipeDomain
import io.realm.RealmObject

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

    override fun mapBy(mapper: RecipeDataToDbMapper, db: DbWrapper<RecipeDB>): RecipeDB {
        return mapper.mapToDb(id, name, urlImg, cookingTime, db)
    }
}

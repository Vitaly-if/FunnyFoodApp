package com.example.funnyfood.data.detail.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.ingredients.IngredientDB
import com.example.funnyfood.domain.detail.ingredient.IngredientDomain

data class IngredientData(
    private val name: String, private val quantity: String,
    private val unit: String,
) : Abstract.Object<IngredientDomain, IngredientDataToDomainMapper>,
    Abstract.Mapper.ToDb<IngredientDB, IngredientDataToDBMapper> {
    override fun map(mapper: IngredientDataToDomainMapper): IngredientDomain {
        return mapper.map(name, quantity, unit)
    }

    override fun mapBy(mapper: IngredientDataToDBMapper): IngredientDB =
        mapper.map(name, quantity, unit)

}

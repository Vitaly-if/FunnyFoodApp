package com.example.funnyfood.data.detail

import com.example.funnyfood.core.Abstract

interface RecipesDetailCacheMapper : Abstract.Mapper {
    fun map(
        recipeDdList: List<Abstract.Object<RecipeDetailData,
                ToRecipeDetailDataMapper>>
    ): List<RecipeDetailData>

    class Base(private val mapper: ToRecipeDetailDataMapper) : RecipesDetailCacheMapper {
        override fun map(
            recipeDdList: List<Abstract.Object<RecipeDetailData,
                    ToRecipeDetailDataMapper>>
        ): List<RecipeDetailData> {
            return recipeDdList.map { recipeDd ->
                recipeDd.map(mapper)
            }
        }
    }
}


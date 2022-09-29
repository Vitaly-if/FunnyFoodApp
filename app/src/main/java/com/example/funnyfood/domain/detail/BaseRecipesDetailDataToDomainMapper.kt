package com.example.funnyfood.domain.detail

import com.example.funnyfood.data.detail.RecipeDetailData
import com.example.funnyfood.data.detail.RecipeDetailDataToDomainMapper
import com.example.funnyfood.data.detail.RecipesDetailDataToDomainMapper
import com.example.funnyfood.domain.ErrorType
import retrofit2.HttpException
import java.net.UnknownHostException

class BaseRecipesDetailDataToDomainMapper(private val recipeDetailMapper: RecipeDetailDataToDomainMapper) :
    RecipesDetailDataToDomainMapper {
    override fun map(list: List<RecipeDetailData>): RecipesDetailDomain {
        val data = mutableListOf<RecipeDetailDomain>()
        list.forEach { RecipeDetailData ->
            data.add(RecipeDetailData.map(recipeDetailMapper))
        }
        return RecipesDetailDomain.Success(data)
    }

    override fun map(e: Exception) = RecipesDetailDomain.Fail(
        when (e) {
            is UnknownHostException -> ErrorType.NO_CONNECTION
            is HttpException -> ErrorType.SERVICE_UNAVAILABLE
            else -> ErrorType.GENERIC_ERROR
        }
    )
}
package com.example.funnyfood.domain

import com.example.funnyfood.data.RecipeData
import com.example.funnyfood.data.RecipeDataToDomainMapper
import com.example.funnyfood.data.RecipesDataToDomainMapper
import retrofit2.HttpException
import java.net.UnknownHostException

class BaseRecipesDataToDomainMapper(private val recipeMapper: RecipeDataToDomainMapper) :
    RecipesDataToDomainMapper {
    override fun map(listResipeData: List<RecipeData>): RecipesDomain {
        val data = mutableListOf<RecipeDomain>()
        listResipeData.forEach { RecipeData ->
            data.add(RecipeData.map(recipeMapper))
        }
        return RecipesDomain.Success(data)
    }

    override fun map(e: Exception) = RecipesDomain.Fail(
        when (e) {
            is UnknownHostException -> ErrorType.NO_CONNECTION
            is HttpException -> ErrorType.SERVICE_UNAVAILABLE
            else -> ErrorType.GENERIC_ERROR
        }
    )
}
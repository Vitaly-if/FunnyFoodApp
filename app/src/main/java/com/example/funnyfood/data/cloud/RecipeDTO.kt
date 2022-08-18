package com.example.funnyfood.data.cloud

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.RecipeData
import com.example.funnyfood.data.ToRecipeDataMapper
import com.google.gson.annotations.SerializedName

data class RecipeDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("urlImg") val urlImg: String,
    @SerializedName("cookingTime") val cookingTime: String
) : Abstract.Object<RecipeData, ToRecipeDataMapper> {
    override fun map(mapper: ToRecipeDataMapper) = mapper.map(id, name, urlImg, cookingTime)

}
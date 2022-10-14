package com.example.funnyfood.data.recipes.cloud

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.recipes.RecipeData
import com.example.funnyfood.data.recipes.ToRecipeDataMapper
import com.google.gson.annotations.SerializedName

data class RecipeDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("duration") val cookingTime: String,
    @SerializedName("favorites") val favoritesDTO: List<FavoritesDTO>,
    @SerializedName("photo") val imageUrl: String
) : Abstract.Object<RecipeData, ToRecipeDataMapper> {
    override fun map(mapper: ToRecipeDataMapper) =
        mapper.map(id, name, imageUrl, cookingTime)


}

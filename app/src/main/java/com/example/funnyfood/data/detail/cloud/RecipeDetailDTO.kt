package com.example.funnyfood.data.detail.cloud

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.ToRecipeDetailMapper
import com.example.funnyfood.data.detail.RecipeDetailData
import com.example.funnyfood.data.detail.cloud.comment.CommentDTO
import com.example.funnyfood.data.detail.cloud.cookingstep.CookingStepDTO
import com.example.funnyfood.data.detail.cloud.favorites.FavoriteDTO
import com.example.funnyfood.data.detail.cloud.ingredient.IngredientDTO
import com.google.gson.annotations.SerializedName

data class RecipeDetailDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("duration") val cookingTime: String,
    @SerializedName("favorites") val favoritesDTO: List<FavoriteDTO>,
    @SerializedName("ingredients") val ingredientsDTO: List<IngredientDTO>,
    @SerializedName("cookingSteps") val cookingStepsDTO: List<CookingStepDTO>,
    @SerializedName("comments") val commentsDTO: List<CommentDTO>,
    @SerializedName("photo") val imageUrl: String
) : Abstract.Object<RecipeDetailData, ToRecipeDetailMapper> {
    override fun map(mapper: ToRecipeDetailMapper): RecipeDetailData {
        return mapper.map(
            id, name, imageUrl, cookingTime, favoritesDTO, ingredientsDTO,
            cookingStepsDTO, commentsDTO
        )
    }
}

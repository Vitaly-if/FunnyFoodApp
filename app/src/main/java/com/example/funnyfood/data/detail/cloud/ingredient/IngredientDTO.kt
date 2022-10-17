package com.example.funnyfood.data.detail.cloud.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.ingredient.IngredientData
import com.google.gson.annotations.SerializedName

data class IngredientDTO(
    @SerializedName("name") val name: String,
    @SerializedName("quantity") val quantity: String,
    @SerializedName("unit") val unit: String
) : Abstract.Object<IngredientData, IngredientCloudToDataMapper> {
    override fun map(mapper: IngredientCloudToDataMapper): IngredientData {
        return mapper.map(name, quantity, unit)
    }
}

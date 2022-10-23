package com.example.funnyfood.data.detail.cloud.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cookingstep.CookingStepData
import com.google.gson.annotations.SerializedName

data class CookingStepDTO(
    @SerializedName("order") val order: Int,
    @SerializedName("step") val step: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("status") val status: Boolean
) : Abstract.Object<CookingStepData, CookingStepCloudToDataMapper> {
    override fun map(mapper: CookingStepCloudToDataMapper): CookingStepData {
        return mapper.map(order, step, duration, status)
    }
}

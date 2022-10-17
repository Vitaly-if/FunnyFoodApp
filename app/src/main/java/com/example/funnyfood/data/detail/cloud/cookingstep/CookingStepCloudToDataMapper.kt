package com.example.funnyfood.data.detail.cloud.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cookingstep.CookingStepData

interface CookingStepCloudToDataMapper : Abstract.Mapper {
    fun map(
        order: Int, step: String,
        duration: String,
        status: Boolean
    ): CookingStepData

    class Base : CookingStepCloudToDataMapper {
        override fun map(
            order: Int,
            step: String,
            duration: String,
            status: Boolean
        ) = CookingStepData(order, step, duration, status)
    }
}
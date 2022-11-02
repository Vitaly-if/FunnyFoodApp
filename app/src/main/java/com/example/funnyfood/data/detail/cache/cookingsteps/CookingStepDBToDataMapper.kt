package com.example.funnyfood.data.detail.cache.cookingsteps

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cookingstep.CookingStepData

interface CookingStepDBToDataMapper : Abstract.Mapper {
    fun map(
        order: Int,
        step: String,
        duration: String,
        status: Boolean,
    ): CookingStepData

    class Base : CookingStepDBToDataMapper {
        override fun map(
            order: Int,
            step: String,
            duration: String,
            status: Boolean,
        ): CookingStepData {
            return CookingStepData(order, step, duration, status)
        }
    }
}
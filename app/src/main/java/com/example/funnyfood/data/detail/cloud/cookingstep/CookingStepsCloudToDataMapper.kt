package com.example.funnyfood.data.detail.cloud.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cookingstep.CookingStepData

interface CookingStepsCloudToDataMapper : Abstract.Mapper {
    fun map(list: List<CookingStepDTO>): List<CookingStepData>
    class Base(
        private val mapper: CookingStepCloudToDataMapper
    ) : CookingStepsCloudToDataMapper {
        override fun map(list: List<CookingStepDTO>): List<CookingStepData> {
            return list.map { it.map(mapper) }
        }
    }
}
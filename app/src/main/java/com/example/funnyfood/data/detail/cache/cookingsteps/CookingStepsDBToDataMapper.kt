package com.example.funnyfood.data.detail.cache.cookingsteps

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cookingstep.CookingStepData

interface CookingStepsDBToDataMapper : Abstract.Mapper {
    fun map(list: List<CookingStepDB>): List<CookingStepData>
    class Base(private var mapper: CookingStepDBToDataMapper) : CookingStepsDBToDataMapper {
        override fun map(list: List<CookingStepDB>): List<CookingStepData> {
            return list.map { it.map(mapper) }
        }
    }
}
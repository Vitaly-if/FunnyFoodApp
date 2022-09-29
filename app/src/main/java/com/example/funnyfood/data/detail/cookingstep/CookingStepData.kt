package com.example.funnyfood.data.detail.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.cookingstep.CookingStepDomain

data class CookingStepData(
    private val order: Int, private val step: String,
    private val duration: String,
    private val status: Boolean
) : Abstract.Object<CookingStepDomain, CookingStepDataToDomainMapper> {
    override fun map(mapper: CookingStepDataToDomainMapper): CookingStepDomain{
        return mapper.map(order, step, duration, status)
    }
}

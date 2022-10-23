package com.example.funnyfood.domain.detail.cookingstep

import com.example.funnyfood.data.detail.cookingstep.CookingStepDataToDomainMapper

class BaseCookingStepDataToDomainMapper : CookingStepDataToDomainMapper {
    override fun map(order: Int, step: String, duration: String, status: Boolean) = CookingStepDomain(
        order, step, duration, status
    )
}
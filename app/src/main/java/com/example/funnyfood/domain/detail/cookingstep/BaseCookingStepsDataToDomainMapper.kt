package com.example.funnyfood.domain.detail.cookingstep

import com.example.funnyfood.data.detail.cookingstep.CookingStepData
import com.example.funnyfood.data.detail.cookingstep.CookingStepDataToDomainMapper
import com.example.funnyfood.data.detail.cookingstep.CookingStepsDataToDomainMapper

class BaseCookingStepsDataToDomainMapper(
private val cookingStepDataToDomainMapper: CookingStepDataToDomainMapper
) : CookingStepsDataToDomainMapper {
    override fun map(list: List<CookingStepData>): List<CookingStepDomain> {
        return list.map { it.map(cookingStepDataToDomainMapper) }
    }
}
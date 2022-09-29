package com.example.funnyfood.ui.detail.cookingstep

import com.example.funnyfood.domain.detail.cookingstep.CookingStepDomain
import com.example.funnyfood.domain.detail.cookingstep.CookingStepDomainToUiMapper
import com.example.funnyfood.domain.detail.cookingstep.CookingStepsDomainToUiMapper

class BaseCookingStepsDomainToUiMapper(
    private val cookingStepDomainToUiMapper: CookingStepDomainToUiMapper
) : CookingStepsDomainToUiMapper {
    override fun map(list: List<CookingStepDomain>): List<CookingStepUi> {
        return list.map { it.map(cookingStepDomainToUiMapper) }
    }
}
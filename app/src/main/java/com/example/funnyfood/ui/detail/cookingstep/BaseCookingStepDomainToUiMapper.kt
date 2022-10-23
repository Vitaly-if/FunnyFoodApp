package com.example.funnyfood.ui.detail.cookingstep

import com.example.funnyfood.domain.detail.cookingstep.CookingStepDomainToUiMapper

class BaseCookingStepDomainToUiMapper : CookingStepDomainToUiMapper {
    override fun map(order: Int, step: String, duration: String, status: Boolean) = CookingStepUi(
        order, step, duration, status
    )
}
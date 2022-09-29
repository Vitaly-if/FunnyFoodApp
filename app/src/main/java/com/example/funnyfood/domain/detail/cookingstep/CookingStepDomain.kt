package com.example.funnyfood.domain.detail.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.detail.cookingstep.CookingStepUi

data class CookingStepDomain(
    private val order: Int, private val step: String,
    private val duration: String,
    private val status: Boolean
) : Abstract.Object<CookingStepUi, CookingStepDomainToUiMapper> {
    override fun map(mapper: CookingStepDomainToUiMapper): CookingStepUi {
        return mapper.map(order, step, duration, status)
    }
}

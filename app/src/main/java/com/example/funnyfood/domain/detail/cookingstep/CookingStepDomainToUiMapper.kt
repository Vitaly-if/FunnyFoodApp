package com.example.funnyfood.domain.detail.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.detail.cookingstep.CookingStepUi

interface CookingStepDomainToUiMapper : Abstract.Mapper {
    fun map(
        order: Int, step: String,
        duration: String,
        status: Boolean
    ): CookingStepUi
}
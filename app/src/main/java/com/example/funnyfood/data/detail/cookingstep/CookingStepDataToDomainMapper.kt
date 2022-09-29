package com.example.funnyfood.data.detail.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.cookingstep.CookingStepDomain
import com.example.funnyfood.ui.detail.cookingstep.CookingStepUi

interface CookingStepDataToDomainMapper : Abstract.Mapper {
    fun map(
        order: Int, step: String,
        duration: String,
        status: Boolean
    ): CookingStepDomain
}
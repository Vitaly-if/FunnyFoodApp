package com.example.funnyfood.domain.detail.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.detail.cookingstep.CookingStepUi

interface CookingStepsDomainToUiMapper : Abstract.Mapper {
    fun map(list: List<CookingStepDomain>): List<CookingStepUi>
}
package com.example.funnyfood.data.detail.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.cookingsteps.CookingStepDB
import com.example.funnyfood.domain.detail.cookingstep.CookingStepDomain

data class CookingStepData(
    private val order: Int, private val step: String,
    private val duration: String,
    private val status: Boolean,
) : Abstract.Object<CookingStepDomain, CookingStepDataToDomainMapper>,
    Abstract.Mapper.ToDb<CookingStepDB, CookingStepDataToDBMapper> {
    override fun map(mapper: CookingStepDataToDomainMapper): CookingStepDomain {
        return mapper.map(order, step, duration, status)
    }

    override fun mapBy(mapper: CookingStepDataToDBMapper): CookingStepDB {
        return mapper.map(order, step, duration, status)
    }
}

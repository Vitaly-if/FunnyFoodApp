package com.example.funnyfood.data.detail.cache.cookingsteps

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cookingstep.CookingStepData
import io.realm.RealmObject

open class CookingStepDB : RealmObject,
    Abstract.Object<CookingStepData, CookingStepDBToDataMapper> {
    var order: Int = -1
    var step: String = ""
    var duration: String = ""
    var status: Boolean = false

    override fun map(mapper: CookingStepDBToDataMapper): CookingStepData {
        return mapper.map(order, step, duration, status)
    }
}

package com.example.funnyfood.data.detail.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.cookingsteps.CookingStepDB

interface CookingStepDataToDBMapper : Abstract.Mapper {
    fun map(
        order: Int,
        step: String,
        duration: String,
        status: Boolean,
    ): CookingStepDB

    class Base : CookingStepDataToDBMapper {
        override fun map(
            order: Int,
            step: String,
            duration: String,
            status: Boolean,
        ): CookingStepDB {
            val cookingStepDB = CookingStepDB()
            return cookingStepDB.also {
                it.order = order
                it.step = step
                it.status = status
                it.duration = duration
            }

        }
    }
}
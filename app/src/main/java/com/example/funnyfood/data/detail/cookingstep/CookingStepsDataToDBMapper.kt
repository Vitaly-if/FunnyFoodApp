package com.example.funnyfood.data.detail.cookingstep

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.cookingsteps.CookingStepDB
import io.realm.RealmList
import io.realm.realmListOf

interface CookingStepsDataToDBMapper : Abstract.Mapper {
    fun map(list: List<CookingStepData>): RealmList<CookingStepDB>
    class Base(private val mapper: CookingStepDataToDBMapper) : CookingStepsDataToDBMapper {
        override fun map(list: List<CookingStepData>): RealmList<CookingStepDB> {
            val realmList: RealmList<CookingStepDB> = realmListOf()
            list.forEach {
                realmList.add(it.mapBy(mapper))
            }
            return realmList
        }
    }
}
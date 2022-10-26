package com.example.funnyfood.data.detail.cache

import io.realm.RealmObject

open class CookingStepDB : RealmObject() {
    var order: Int = -1
    var step: String = ""
    var duration: String = ""
    var status: Boolean = false
}

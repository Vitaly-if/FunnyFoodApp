package com.example.funnyfood.data.detail.cache

import io.realm.RealmObject

open class FavoriteDB : RealmObject() {
    var userName: String = ""
}

package com.example.funnyfood.data.detail.cache.favorites

import com.example.funnyfood.data.detail.favorites.FavoriteData
import io.realm.RealmObject

open class FavoriteDB : RealmObject, FavoriteRealm {

    var userName: String = ""

    override fun map(mapper: FavoriteDBToData): FavoriteData {
        return mapper.map(userName)
    }

}

interface FavoriteRealm {
    fun map(mapper: FavoriteDBToData): FavoriteData
}
package com.example.funnyfood.data.detail.cache.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.favorites.FavoriteData
import io.realm.RealmList

interface FavoritesDBToData : Abstract.Mapper {
    fun map(list: RealmList<FavoriteDB>): List<FavoriteData>
    class Base(private val mapper: FavoriteDBToData) : FavoritesDBToData {
        override fun map(list: RealmList<FavoriteDB>): List<FavoriteData> {
            return list.map { it.map(mapper) }
        }
    }
}
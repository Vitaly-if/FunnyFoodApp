package com.example.funnyfood.data.detail.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.favorites.FavoriteDB
import io.realm.RealmList

interface FavoritesDataToDb: Abstract.Mapper {
    fun map(list: List<FavoriteData>): RealmList<FavoriteDB>
    class Base(private val mapper: FavoriteDataToDb) : FavoritesDataToDb {
        override fun map(list: List<FavoriteData>): RealmList<FavoriteDB> {
            val listRealm: RealmList<FavoriteDB> = RealmList()
             list.forEach {
                 listRealm.add( it.mapBy(mapper))
                }
            return listRealm
        }

    }
}
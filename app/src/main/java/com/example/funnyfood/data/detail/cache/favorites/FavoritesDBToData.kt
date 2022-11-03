package com.example.funnyfood.data.detail.cache.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.favorites.FavoriteData

interface FavoritesDBToData : Abstract.Mapper {
    fun map(list: List<FavoriteDB>): List<FavoriteData>
    class Base(private val mapper: FavoriteDBToData) : FavoritesDBToData {
        override fun map(list: List<FavoriteDB>): List<FavoriteData> {
            return list.map {
                it.map(mapper)
            }
        }
    }
}
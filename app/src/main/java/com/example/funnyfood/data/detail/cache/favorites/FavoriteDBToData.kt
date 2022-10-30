package com.example.funnyfood.data.detail.cache.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.favorites.FavoriteData

interface FavoriteDBToData : Abstract.Mapper {
    fun map(name: String): FavoriteData
    class Base(name: String) : FavoriteDBToData {
        override fun map(name: String): FavoriteData {
            return FavoriteData(name)
        }
    }
}
package com.example.funnyfood.data.detail.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.favorites.FavoriteDB

interface FavoriteDataToDb: Abstract.Mapper {
    fun map(name: String): FavoriteDB
    class Base(): FavoriteDataToDb {
        override fun map(name: String): FavoriteDB {
            val favorite = FavoriteDB()
            favorite.userName = name
            return favorite
        }
    }
}
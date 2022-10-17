package com.example.funnyfood.data.detail.cloud.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.favorites.FavoriteData

interface FavoriteCloudToDataMapper : Abstract.Mapper {
    fun map(name: String): FavoriteData
    class Base : FavoriteCloudToDataMapper {
        override fun map(name: String) = FavoriteData(name)
    }
}
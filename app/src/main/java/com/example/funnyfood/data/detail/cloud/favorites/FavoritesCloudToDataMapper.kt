package com.example.funnyfood.data.detail.cloud.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.favorites.FavoriteData

interface FavoritesCloudToDataMapper : Abstract.Mapper {
    fun map(list: List<FavoriteDTO>): List<FavoriteData>
    class Base(
        private val mapper: FavoriteCloudToDataMapper
    ) : FavoritesCloudToDataMapper {
        override fun map(list: List<FavoriteDTO>): List<FavoriteData> {
            return list.map { it.map(mapper) }
        }
    }
}
package com.example.funnyfood.data.detail.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.favorite.FavoriteDomain

interface FavoritesDataToDomain : Abstract.Mapper {
    fun map(list: List<FavoriteData>): List<FavoriteDomain>
    class Base(
        private val mapper: FavoriteDataToDomain
    ) : FavoritesDataToDomain {
        override fun map(list: List<FavoriteData>): List<FavoriteDomain> {
            return list.map { it.map(mapper) }
        }
    }
}
package com.example.funnyfood.data.detail.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.domain.detail.favorite.FavoriteDomain

interface FavoriteDataToDomain : Abstract.Mapper {
    fun map(name: String): FavoriteDomain
    class Base : FavoriteDataToDomain {
        override fun map(name: String) = FavoriteDomain(name)
    }
}
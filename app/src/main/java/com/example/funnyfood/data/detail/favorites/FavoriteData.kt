package com.example.funnyfood.data.detail.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.favorites.FavoriteDB
import com.example.funnyfood.domain.detail.favorite.FavoriteDomain

data class FavoriteData(private val userName: String) :
    Abstract.Object<FavoriteDomain, FavoriteDataToDomain>, Abstract.Mapper.ToDb<FavoriteDB,
        FavoriteDataToDb> {
    override fun map(mapper: FavoriteDataToDomain): FavoriteDomain {
        return mapper.map(userName)
    }

    override fun mapBy(mapper: FavoriteDataToDb): FavoriteDB {
        return mapper.map(userName)
    }
}

package com.example.funnyfood.domain.detail.favorite

import com.example.funnyfood.core.Abstract

interface FavoritesDomainToUiMapper : Abstract.Mapper {
    fun map(list: List<FavoriteDomain>): Boolean
    class Base(
        private val mapper: FavoriteDomainToUiMapper,
    ) : FavoritesDomainToUiMapper {
        override fun map(list: List<FavoriteDomain>): Boolean {
            list.forEach { if(it.map(mapper)) return true }
            return false

        }
    }
}
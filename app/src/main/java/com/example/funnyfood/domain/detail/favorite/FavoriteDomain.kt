package com.example.funnyfood.domain.detail.favorite

import com.example.funnyfood.core.Abstract

data class FavoriteDomain(private val userName: String):Abstract.Object<Boolean, FavoriteDomainToUiMapper> {
    override fun map(mapper: FavoriteDomainToUiMapper): Boolean {
        return mapper.map(userName)
    }
}

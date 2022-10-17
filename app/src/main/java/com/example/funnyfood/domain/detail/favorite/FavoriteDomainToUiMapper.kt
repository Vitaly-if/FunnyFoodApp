package com.example.funnyfood.domain.detail.favorite

import com.example.funnyfood.core.Abstract

interface FavoriteDomainToUiMapper : Abstract.Mapper {
    fun map(name: String): Boolean
    class Base(
        private val userLogin: String
    ) : FavoriteDomainToUiMapper {
        override fun map(name: String): Boolean {
            return userLogin == name
        }
    }
}
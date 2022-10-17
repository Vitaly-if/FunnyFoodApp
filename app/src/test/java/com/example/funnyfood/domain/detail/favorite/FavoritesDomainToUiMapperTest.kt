package com.example.funnyfood.domain.detail.favorite

import org.junit.Assert.*
import org.junit.Test

class FavoritesDomainToUiMapperTest {
    @Test
    fun mapper_test_favorite_true() {
        val mapperFavorite = FavoriteDomainToUiMapper.Base("user1")
        val mapperFavorites = FavoritesDomainToUiMapper.Base(mapperFavorite)
        val favoritesDomain = listOf(
            FavoriteDomain("user3"),
            FavoriteDomain("user4"),
            FavoriteDomain("user1"),
            FavoriteDomain("user6"),
        )
        assertTrue(mapperFavorites.map(favoritesDomain))
    }
    @Test
    fun mapper_test_favorite_false() {
        val mapperFavorite = FavoriteDomainToUiMapper.Base("user0")
        val mapperFavorites = FavoritesDomainToUiMapper.Base(mapperFavorite)
        val favoritesDomain = listOf(
            FavoriteDomain("user3"),
            FavoriteDomain("user4"),
            FavoriteDomain("user1"),
            FavoriteDomain("user6"),
        )
        assertFalse(mapperFavorites.map(favoritesDomain))
    }
}
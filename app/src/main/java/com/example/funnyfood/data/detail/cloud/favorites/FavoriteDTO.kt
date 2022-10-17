package com.example.funnyfood.data.detail.cloud.favorites

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.favorites.FavoriteData
import com.google.gson.annotations.SerializedName

data class FavoriteDTO(
    @SerializedName("username") val userName: String
) : Abstract.Object<FavoriteData, FavoriteCloudToDataMapper> {
    override fun map(mapper: FavoriteCloudToDataMapper): FavoriteData {
        return mapper.map(userName)
    }
}

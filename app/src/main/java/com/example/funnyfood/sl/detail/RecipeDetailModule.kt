package com.example.funnyfood.sl.detail

import com.example.funnyfood.data.ToRecipeDetailMapper
import com.example.funnyfood.data.detail.RecipeDetailDataToDbMapper
import com.example.funnyfood.data.detail.RecipesDetailCacheMapper
import com.example.funnyfood.data.detail.RecipesDetailRepository
import com.example.funnyfood.data.detail.ToRecipeDetailDataMapper
import com.example.funnyfood.data.detail.cache.RecipesDetailCacheDataSource
import com.example.funnyfood.data.detail.cloud.RecipeDetailCloudDataSource
import com.example.funnyfood.data.detail.cloud.RecipeDetailService
import com.example.funnyfood.data.detail.cloud.RecipesDetailCloudMapper
import com.example.funnyfood.domain.detail.BaseRecipeDetailDataToDomainMapper
import com.example.funnyfood.domain.detail.BaseRecipesDetailDataToDomainMapper
import com.example.funnyfood.domain.detail.RecipesDetailInteractor
import com.example.funnyfood.sl.core.BaseModule
import com.example.funnyfood.sl.core.CoreModule
import com.example.funnyfood.ui.detail.BaseRecipeDetailDomainToUiMapper
import com.example.funnyfood.ui.detail.BaseRecipesDetailDomainToUiMapper
import com.example.funnyfood.ui.detail.RecipeDetailViewModel
import com.example.funnyfood.ui.detail.RecipesDetailCommunication

class RecipeDetailModule(private val coreModule: CoreModule) : BaseModule<RecipeDetailViewModel> {
    override fun getViewModel(): RecipeDetailViewModel {
        return RecipeDetailViewModel(
            getRecipesDetailInteractor(),
            getRecipesDetailMapper(),
            getRecipesDetailCommunication(),
            coreModule.navigator,
            coreModule.dispatchers
        )
    }

    private fun getRecipesDetailInteractor() = RecipesDetailInteractor.Base(
        getRecipesDetailRepository(),
        BaseRecipesDetailDataToDomainMapper(BaseRecipeDetailDataToDomainMapper())
    )

    private fun getRecipesDetailRepository(): RecipesDetailRepository {
        val cloudDataSource = if (coreModule.useMock)
            RecipeDetailCloudDataSource.Mock(
                coreModule.resourceProvider.getResource(),
                coreModule.gson
            )
        else
            RecipeDetailCloudDataSource.Base(
                coreModule.makeService(RecipeDetailService::class.java),
                coreModule.gson
            )
        return RecipesDetailRepository.Base(
            cloudDataSource,
            RecipesDetailCacheDataSource.Base(coreModule.realmProvider, RecipeDetailDataToDbMapper.Base()),
            RecipesDetailCloudMapper.Base(ToRecipeDetailMapper.Base()),
            coreModule.recipeCache,
            RecipesDetailCacheMapper.Base(ToRecipeDetailDataMapper.Base())
        )
    }

    private fun getRecipesDetailMapper() = BaseRecipesDetailDomainToUiMapper(
        coreModule.resourceProvider,
        BaseRecipeDetailDomainToUiMapper()
    )

    private fun getRecipesDetailCommunication() = RecipesDetailCommunication.Base()
}
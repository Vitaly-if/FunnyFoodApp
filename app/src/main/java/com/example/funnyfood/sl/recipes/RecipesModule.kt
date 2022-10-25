package com.example.funnyfood.sl.recipes

import com.example.funnyfood.data.recipes.*
import com.example.funnyfood.data.recipes.cache.RecipesCacheDataSource
import com.example.funnyfood.data.recipes.cloud.RecipeCloudDataSource
import com.example.funnyfood.data.recipes.cloud.RecipeService
import com.example.funnyfood.domain.recipes.BaseRecipeDataToDomainMapper
import com.example.funnyfood.domain.recipes.BaseRecipesDataToDomainMapper
import com.example.funnyfood.domain.recipes.RecipesDomainToUiMapper
import com.example.funnyfood.domain.recipes.RecipesInteractor
import com.example.funnyfood.sl.core.BaseModule
import com.example.funnyfood.sl.core.CoreModule
import com.example.funnyfood.ui.recipes.RecipesCommunication
import com.example.funnyfood.ui.recipes.BaseRecipeDomainToUiMapper
import com.example.funnyfood.ui.recipes.BaseRecipesDomainToUiMapper
import com.example.funnyfood.ui.recipes.RecipeListViewModel

class RecipesModule(private val coreModule: CoreModule) : BaseModule<RecipeListViewModel> {
    override fun getViewModel(): RecipeListViewModel {
        return RecipeListViewModel(
            getRecipesInteractor(),
            getRecipesMapper(),
            getRecipesCommunication(),
            coreModule.recipeCache,
            coreModule.navigator,
            coreModule.navigationCommunication
        )
    }
    private fun getRecipesInteractor() = RecipesInteractor.Base(
        getResipesRepository(),
        BaseRecipesDataToDomainMapper(BaseRecipeDataToDomainMapper())
    )

    private fun getResipesRepository(): RecipesRepository {
        val useMocks = true
        val cloudDataSource = if (useMocks)
            RecipeCloudDataSource.Mock(coreModule.resourceProvider.getResource(), coreModule.gson)
        else
            RecipeCloudDataSource.Base(
                coreModule.makeService(RecipeService::class.java),
                coreModule.gson
            )
        return RecipesRepository.Base(
            cloudDataSource,
            RecipesCacheDataSource.Base(coreModule.realmProvider, RecipeDataToDbMapper.Base()),
            RecipesCloudMapper.Base(ToRecipeDataMapper.Base()),
            RecipesCacheMapper.Base(ToRecipeDataMapper.Base())
        )
    }

    private fun getRecipesMapper(): RecipesDomainToUiMapper {
        return BaseRecipesDomainToUiMapper(
            coreModule.resourceProvider, BaseRecipeDomainToUiMapper()
        )
    }

    private fun getRecipesCommunication(): RecipesCommunication {
        return RecipesCommunication.Base()
    }
}







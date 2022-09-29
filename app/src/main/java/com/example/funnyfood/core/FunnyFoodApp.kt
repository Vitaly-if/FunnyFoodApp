package com.example.funnyfood.core

import android.app.Application
import com.example.funnyfood.data.*
import com.example.funnyfood.data.recipes.*
import com.example.funnyfood.data.recipes.cache.RealmProvider
import com.example.funnyfood.data.recipes.cache.RecipesCacheDataSource
import com.example.funnyfood.data.recipes.cloud.RecipeCloudDataSource
import com.example.funnyfood.data.recipes.cloud.RecipeService
import com.example.funnyfood.domain.recipes.BaseRecipeDataToDomainMapper
import com.example.funnyfood.domain.recipes.BaseRecipesDataToDomainMapper
import com.example.funnyfood.domain.recipes.RecipesInteractor
import com.example.funnyfood.ui.*
import com.example.funnyfood.ui.detail.RecipeDetailViewModel
import com.example.funnyfood.ui.recipes.BaseRecipeDomainToUiMapper
import com.example.funnyfood.ui.recipes.BaseRecipesDomainToUiMapper
import com.example.funnyfood.ui.recipes.RecipeListViewModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import io.realm.Realm
import retrofit2.Retrofit

class FunnyFoodApp : Application() {

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    lateinit var mainViewModel: MainViewModel
    lateinit var recipesViewModel: RecipeListViewModel
    lateinit var recipeDetailViewModel: RecipeDetailViewModel

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val useMocks = true
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .build()

        val service = retrofit.create(RecipeService::class.java)

        val gson = Gson()

        val cloudDataSource = if (useMocks)
            RecipeCloudDataSource.Mock(resources, gson)
        else
            RecipeCloudDataSource.Base(service, gson)

        val cacheDataSource =
            RecipesCacheDataSource.Base(RealmProvider.Base(), RecipeDataToDbMapper.Base())
        val toRecipeMapper = ToRecipeDataMapper.Base()
        val recipesCloudMapper = RecipesCloudMapper.Base(toRecipeMapper)
        val recipesCacheMapper = RecipesCacheMapper.Base(toRecipeMapper)
        val recipesRepository = RecipesRepository.Base(
            cloudDataSource,
            cacheDataSource,
            recipesCloudMapper,
            recipesCacheMapper
        )
        val recipesInteractor = RecipesInteractor.Base(
            recipesRepository,
            BaseRecipesDataToDomainMapper(BaseRecipeDataToDomainMapper())
        )
        val communication = RecipesCommunication.Base()
        val resourceProvider = ResourceProvider.Base(this)
        val navigator = Navigator.Base(this)
        val navigationCommunication = NavigationCommunication.Base()
        mainViewModel = MainViewModel(navigator, navigationCommunication)

        recipesViewModel = RecipeListViewModel(
            recipesInteractor, BaseRecipesDomainToUiMapper(
                resourceProvider, BaseRecipeDomainToUiMapper()
            ), communication, navigator, navigationCommunication
        )

        recipeDetailViewModel = RecipeDetailViewModel(
            recipeDetailInteractor, BaseRecipeDetailDomainToUiMapper(
                resourceProvider
            ), communication, navigator, navigationCommunication
        )

    }

}

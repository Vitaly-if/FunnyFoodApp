package com.example.funnyfood.core

import android.app.Application
import android.util.Log
import com.example.funnyfood.data.*
import com.example.funnyfood.data.cache.RealmProvider
import com.example.funnyfood.data.cache.RecipesCacheDataSource
import com.example.funnyfood.data.cloud.RecipeCloudDataSource
import com.example.funnyfood.data.cloud.RecipeMockServer
import com.example.funnyfood.data.cloud.RecipeService
import com.example.funnyfood.domain.BaseRecipeDataToDomainMapper
import com.example.funnyfood.domain.BaseRecipesDataToDomainMapper
import com.example.funnyfood.domain.RecipesInteractor
import com.example.funnyfood.ui.*
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import io.realm.Realm
import retrofit2.Retrofit

class FunnyFoodApp: Application() {

    private companion object {
        const val  BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val recipeMockServer = RecipeMockServer.Base()
        recipeMockServer.startServer("recipe.json",this)
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        Thread.sleep(500)
        Log.i("MyTag", "${recipeMockServer.getBaseUrlMockServer()} after init retrofit")
        var retrofit = Retrofit.Builder()
            .baseUrl(recipeMockServer.getBaseUrlMockServer())
            .client(client)
            .build()

        val service = retrofit.create(RecipeService::class.java)

        val gson = Gson()
        val cloudDataSource = RecipeCloudDataSource.Base(service, gson)
        Log.i("MyTag", "${recipeMockServer.getBaseUrlMockServer()} before init retrofit")

        val caheDataSource = RecipesCacheDataSource.Base(RealmProvider.Base(), RecipeDataToDbMapper.Base())
        val toRecipeMapper = ToRecipeDataMapper.Base()
        val recipesCloudMapper = RecipesCloudMapper.Base(toRecipeMapper)
        val recipesCacheMapper = RecipesCacheMapper.Base(toRecipeMapper)
        val recipesRepository = RecipesRepository.Base(
            cloudDataSource,
            caheDataSource,
            recipesCloudMapper,
            recipesCacheMapper
        )
        val recipesInteractor = RecipesInteractor.Base(
            recipesRepository,
            BaseRecipesDataToDomainMapper(BaseRecipeDataToDomainMapper())
            )
        val communication = RecipesCommunication.Base()
        val resourceProvider = ResourceProvider.Base(this)
        mainViewModel = MainViewModel(
            recipesInteractor,
            BaseRecipesDomainToUiMapper(resourceProvider, BaseRecipeDomainToUiMapper()),
            communication
        )
    }

}

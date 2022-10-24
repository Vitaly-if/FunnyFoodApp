package com.example.funnyfood.sl

import android.content.Context
import com.example.funnyfood.data.recipes.cache.RealmProvider
import com.example.funnyfood.ui.MainViewModel
import com.example.funnyfood.ui.NavigationCommunication
import com.example.funnyfood.ui.Navigator
import com.example.funnyfood.ui.ResourceProvider
import com.example.funnyfood.ui.recipes.RecipeCache
import com.google.gson.Gson
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class CoreModule : BaseModule<MainViewModel> {

    private companion object {
        const val BASE_URL = "http://foodapi.dzolotov.tech/"
    }

    lateinit var resourceProvider: ResourceProvider
    lateinit var gson: Gson
    lateinit var realmProvider: RealmProvider
    lateinit var navigator: Navigator
    lateinit var navigationCommunication: NavigationCommunication
    lateinit var recipeCache: RecipeCache
    private lateinit var retrofit: Retrofit

    fun init(context: Context) {
        Realm.init(context)
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .build()

        gson = Gson()
        realmProvider = RealmProvider.Base()
        resourceProvider = ResourceProvider.Base(context)
        recipeCache = RecipeCache.Base(resourceProvider)
        navigator = Navigator.Base(context)
        navigationCommunication = NavigationCommunication.Base()
    }

    fun <T> makeService(clazz: Class<T>): T = retrofit.create(clazz)

    override fun getViewModel(): MainViewModel {
        return MainViewModel(navigator, navigationCommunication)
    }
}
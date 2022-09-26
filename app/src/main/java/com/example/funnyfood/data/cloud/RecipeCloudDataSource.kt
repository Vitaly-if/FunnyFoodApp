package com.example.funnyfood.data.cloud

import android.content.res.Resources
import com.example.funnyfood.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader

interface RecipeCloudDataSource {

    suspend fun fetchRecipes(): List<RecipeDTO>

    abstract class Abstract(private val gson: Gson) : RecipeCloudDataSource {
        override suspend fun fetchRecipes(): List<RecipeDTO> = gson.fromJson(
            getDataAsString(),
            object : TypeToken<List<RecipeDTO>>() {}.type
        )


        protected abstract suspend fun getDataAsString(): String
    }


    class Base(
        private val service: RecipeService,
        gson: Gson
    ) : RecipeCloudDataSource.Abstract(gson) {
        override suspend fun getDataAsString() = service.fetchRecipes().string()

    }

    class Mock(
        private val resources: Resources,
        gson: Gson
    ) : RecipeCloudDataSource.Abstract(gson) {
        override suspend fun getDataAsString() =
            resources.openRawResource(R.raw.recipes).bufferedReader()
                .use(BufferedReader::readText)


    }
}
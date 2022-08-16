package com.example.funnyfood.data.cloud

import android.content.Context
import android.provider.Contacts
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.funnyfood.core.FunnyFoodApp
import kotlinx.coroutines.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

interface RecipeMockServer {

    fun startServer(patch: String, context: Context)
    fun getBaseUrlMockServer(): String
    fun stopServer()

    class Base() : RecipeMockServer {
        var server: MockWebServer = MockWebServer()
        var baseUrl = "http"
        override fun startServer(patch: String, context: Context) {
            GlobalScope.async {
                server.enqueue(
                    MockResponse().setResponseCode(200)
                        .setBody(context.assets
                            .open("recipe.json")
                            .bufferedReader().use {
                                it.readText()
                            })
                )
                server.start()
                baseUrl = server.url("").toString()
            }
        }
        override fun getBaseUrlMockServer(): String {
            return baseUrl
        }
        override fun stopServer() {

        }
    }
}
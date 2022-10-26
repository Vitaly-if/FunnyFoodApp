package com.example.funnyfood.ui

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.annotation.StringRes
import com.example.funnyfood.core.PreferencesProvider

interface ResourceProvider : PreferencesProvider {

    fun getString(@StringRes id: Int): String
    fun getResource(): Resources

    class Base(private val context: Context) : ResourceProvider {
        override fun getString(id: Int): String = context.getString(id)
        override fun getResource() = context.resources

        override fun provideSharedPreferences(name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

    }

}
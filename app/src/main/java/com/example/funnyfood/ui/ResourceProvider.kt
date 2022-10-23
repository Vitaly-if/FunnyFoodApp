package com.example.funnyfood.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.StringRes
import com.example.funnyfood.core.PreferencesProvider

interface ResourceProvider : PreferencesProvider {

    fun getString(@StringRes id: Int): String

    class Base(private val context: Context) : ResourceProvider {
        override fun getString(id: Int): String = context.getString(id)
        override fun provideSharedPreferences(name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

    }

}
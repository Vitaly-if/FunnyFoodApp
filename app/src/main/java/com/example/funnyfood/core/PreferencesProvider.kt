package com.example.funnyfood.core

import android.content.SharedPreferences

interface PreferencesProvider {
    fun provideSharedPreferences(name: String) : SharedPreferences
}
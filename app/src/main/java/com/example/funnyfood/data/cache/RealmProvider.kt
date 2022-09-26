package com.example.funnyfood.data.cache

import io.realm.Realm

interface RealmProvider {

    fun provider(): Realm

    class Base : RealmProvider {
        override fun provider(): Realm {
            return Realm.getDefaultInstance()
        }
    }
}
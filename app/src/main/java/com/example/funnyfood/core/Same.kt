package com.example.funnyfood.core

interface Same<T> {
    fun itemToCompare(item: T): Boolean
}
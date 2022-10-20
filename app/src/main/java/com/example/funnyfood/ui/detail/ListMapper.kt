package com.example.funnyfood.ui.detail

import com.example.funnyfood.core.Abstract

interface ListMapper<T> : Abstract.Mapper.Data<List<T>, Unit> {
    class Empty<T> : ListMapper<T> {
        override fun map(data: List<T>) = Unit
    }
}
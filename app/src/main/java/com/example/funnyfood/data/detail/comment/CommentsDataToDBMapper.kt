package com.example.funnyfood.data.detail.comment

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.cache.comments.CommentDB
import io.realm.RealmList
import io.realm.realmListOf

interface CommentsDataToDBMapper: Abstract.Mapper {
    fun map(list: List<CommentData>) : RealmList<CommentDB>
    class Base(private val mapper: CommentDataToDBMapper) : CommentsDataToDBMapper {
        override fun map(list: List<CommentData>): RealmList<CommentDB> {
            val realmList: RealmList<CommentDB> = realmListOf()
            list.forEach {
                realmList.add(it.mapBy(mapper))
            }
            return realmList
        }
    }
}
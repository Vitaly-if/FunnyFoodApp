package com.example.funnyfood.data.detail.cache.comments

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.data.detail.comment.CommentData
import io.realm.RealmObject

open class CommentDB: RealmObject, Abstract.Object<CommentData, CommentDBToDataMapper> {
    var author: String = ""
    var avatar: String = ""
    var date: String = ""
    var comment: String = ""
    var image: String = ""
    override fun map(mapper: CommentDBToDataMapper): CommentData {
        return mapper.map(author, avatar, date, comment, image)
    }
}

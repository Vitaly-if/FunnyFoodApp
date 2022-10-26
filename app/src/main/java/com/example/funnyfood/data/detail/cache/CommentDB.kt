package com.example.funnyfood.data.detail.cache

import io.realm.RealmObject

open class CommentDB : RealmObject() {
    var author: String = ""
    var avatar: String = ""
    var date: String = ""
    var comment: String = ""
    var image: String = ""
}

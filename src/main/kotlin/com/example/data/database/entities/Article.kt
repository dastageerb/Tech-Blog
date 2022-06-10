package com.example.data.database.entities

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId


@kotlinx.serialization.Serializable
data class Article(
    @BsonId
    var id:String = ObjectId().toHexString(),
    var title:String?=null,
    var description:String?=null,
    var thumbnail:String?=null,
    var imageUrl:String?=null,
    var viewType: ViewType?=null,
    var timeStamp:Long = System.currentTimeMillis(),
    var categoryType: Category?=null
    )
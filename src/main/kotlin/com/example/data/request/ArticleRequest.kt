package com.example.data.request

import com.example.data.database.models.ViewType
import org.bson.BsonTimestamp
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@kotlinx.serialization.Serializable
data class ArticleRequest(
    var title:String?=null,
    var description:String?=null,
    var thumbnail:String?=null,
    var imageUrl:String?=null,
    var viewType: Int?=null,
)
package com.example.model.request

@kotlinx.serialization.Serializable
data class ArticleRequest(
    var title:String?=null,
    var description:String?=null,
    var thumbnail:String?=null,
    var imageUrl:String?=null,
    var viewType: String?=null,
    var categoryType: String?=null
)
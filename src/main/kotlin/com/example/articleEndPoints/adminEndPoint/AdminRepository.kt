package com.example.articleEndPoints.adminEndPoint

import com.example.data.dbEntities.Article
import com.example.model.responses.ResponseMessage

interface AdminRepository
{

    suspend fun addArticle(article: Article): ResponseMessage

    suspend fun deleteArticle(id:String): ResponseMessage



}
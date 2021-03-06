package com.example.articleEndPoints.adminEndPoint

import com.example.data.dbEntities.Article
import com.example.model.responses.ResponseMessage

interface AdminRepository
{

    suspend fun addArticle(article: Article): ResponseMessage

    suspend fun deleteArticleById(id:String): ResponseMessage


    suspend fun updateArticle(article: Article): ResponseMessage



}
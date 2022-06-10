package com.example.endpoint

import com.example.data.database.entities.Article
import com.example.model.responses.ResponseMessage

interface ArticleRepository
{

    suspend fun getAllArticles():List<Article>


    suspend fun addArticle(article: Article): ResponseMessage

}
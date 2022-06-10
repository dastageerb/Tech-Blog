package com.example.endpoint

import com.example.data.database.models.Article
import com.example.data.responses.ResponseMessage

interface ArticleRepository
{

    suspend fun getAllArticles():List<Article>


    suspend fun addArticle(article: Article): ResponseMessage

}
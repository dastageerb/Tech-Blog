package com.example.articleEndPoints.clientEndPoints

import com.example.data.dbEntities.Article

interface ClientRepository
{

    suspend fun getAllArticles():List<Article>


    suspend fun getArticleById(id:String): Article?

}
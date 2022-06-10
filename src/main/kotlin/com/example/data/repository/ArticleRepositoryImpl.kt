package com.example.data.repository

import com.example.data.database.entities.Article
import com.example.model.request.RequestStatus
import com.example.model.responses.ResponseMessage
import com.example.endpoint.ArticleRepository
import org.litote.kmongo.coroutine.CoroutineDatabase


class ArticleRepositoryImpl(private val db:CoroutineDatabase): ArticleRepository
{

    private val collection = db.getCollection<Article>()


    override suspend fun getAllArticles(): List<Article>
    {
        try
        {
            val response = collection.find().toList()
            return response
        }catch (e:Exception)
        {
            e.printStackTrace()
        }
        return emptyList()
        //android.util.Log.d(TAG, "getAllArticles: ")

    }

    override suspend fun addArticle(article: Article): ResponseMessage
    {
        try
        {
            val value = collection.insertOne(article).wasAcknowledged()
            if (value)
            {
                return ResponseMessage(RequestStatus.SUCCESS,"Article Inserted Successfully")
            }
        }catch (e:Exception)
        {
            e.printStackTrace()
        }

        return ResponseMessage(RequestStatus.FAILED,"Some Error occurred")
    }


}
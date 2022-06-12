package com.example.data.repositoryImpl

import com.example.data.database.entities.Article
import com.example.model.request.RequestStatus
import com.example.model.responses.ResponseMessage
import com.example.endpoint.ArticleRepository
import com.example.model.request.ArticleRequest
import org.litote.kmongo.coroutine.CoroutineDatabase
import javax.management.Query.eq


class ArticleRepositoryImpl(private val db:CoroutineDatabase): ArticleRepository
{

    private val collection = db.getCollection<Article>()


    override suspend fun getAllArticles(): List<Article>
    {
        try
        {
            return collection.find().toList()
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

    override suspend fun getArticleById(id: String): Article?
    {
        try
        {
            print("Collection ->>>>>>>>>>>>>>>"+collection.findOneById(id))
            return collection.findOneById(id)

        }catch (e:Exception)
        {
            e.printStackTrace()
        }
        return null
    }


//
//    override suspend fun getArticleById(id: String): Article
//    {
//
//    }


}
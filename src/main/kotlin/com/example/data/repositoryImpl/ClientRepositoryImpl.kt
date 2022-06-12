package com.example.data.repositoryImpl

import com.example.data.dbEntities.Article
import com.example.articleEndPoints.clientEndPoints.ClientRepository
import org.litote.kmongo.coroutine.CoroutineDatabase


class ClientRepositoryImpl(private val db:CoroutineDatabase): ClientRepository
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


    override suspend fun getArticleById(id: String): Article?
    {
        try
        {
            return collection.findOneById(id)
        }catch (e:Exception)
        {
            e.printStackTrace()
        }
        return null
    }



}
package com.example.data.repositoryImpl

import com.example.data.dbEntities.Article
import com.example.articleEndPoints.adminEndPoint.AdminRepository
import com.example.data.dbEntities.ViewType
import com.example.model.request.RequestStatus
import com.example.model.responses.ResponseMessage
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.updateOne


class AdminRepositoryImpl(private val db:CoroutineDatabase): AdminRepository
{

    private val collection = db.getCollection<Article>()


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

    }  // addArticle closed

    override suspend fun deleteArticleById(id: String): ResponseMessage
    {
        try
        {
            val value = collection.deleteOneById(id).wasAcknowledged()

            if (value)
            {
                return ResponseMessage(RequestStatus.SUCCESS,"Article Deleted Successfully")
            }
        }catch (e:Exception)
        {
            e.printStackTrace()
        }

        return ResponseMessage(RequestStatus.FAILED,"Some Error occurred")


    } // deleteArticle closed


    override suspend fun updateArticle(article: Article): ResponseMessage {
        try
        {
            val value = collection.updateOne(article).wasAcknowledged()
            if (value)
            {
                return ResponseMessage(RequestStatus.SUCCESS, "Article Updated Successfully")
            }
        } catch (e: Exception)
        {
            e.printStackTrace()
        }

        return ResponseMessage(RequestStatus.FAILED, "Some Error occurred")

    } // updateById



//
//    override suspend fun getArticleById(id: String): Article
//    {
//
//    }


}
package com.example

import com.example.data.repository.ArticleRepositoryImpl
import com.example.endpoint.ArticleRepository
import com.example.endpoint.articleEndPoints
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun main()
{

    embeddedServer(Netty, port = 8080, host = "127.0.0.0" ,watchPaths = listOf("models/Article","plugins/routing"))
    {
        configureRouting()
        configureSerialization()

        val password = System.getenv("password")
        //val db:CoroutineDatabase =

       val uri = "mongodb+srv://dastageer:$password@cluster0.shinzsq.mongodb.net/thetechblog?retryWrites=true&w=majority"
        val db = KMongo.createClient(connectionString = uri).coroutine.getDatabase("thetechblog")
    val repository: ArticleRepository = ArticleRepositoryImpl(db)
        articleEndPoints(repository)


        //  configureMonitoring()
        //configureHTTP()
       // configureSecurity()
    }.start(wait = true)
}

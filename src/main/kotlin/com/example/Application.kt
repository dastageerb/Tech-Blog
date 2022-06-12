package com.example

import com.example.articleEndPoints.adminEndPoint.AdminRepository
import com.example.articleEndPoints.adminEndPoint.adminEndPoints
import com.example.articleEndPoints.clientEndPoints.ClientRepository
import com.example.articleEndPoints.clientEndPoints.clientEndPoints
import com.example.data.repositoryImpl.ClientRepositoryImpl
import com.example.data.repositoryImpl.AdminRepositoryImpl
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

        val repository: ClientRepository = ClientRepositoryImpl(db)
       val adminRepo : AdminRepository = AdminRepositoryImpl(db)

        clientEndPoints(repository)
        adminEndPoints(adminRepo)

        //  configureMonitoring()
        //configureHTTP()
       // configureSecurity()
    }.start(wait = true)
}

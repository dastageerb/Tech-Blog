package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

//
//        get("/articles")
//        {
//            val list = mutableListOf<Article>()
//            list.add(
//                Article(1,"Kotlin Supermacy","Kotlin to take over the programming" +
//                    " world with its full stack development")
//            )
//            list.add(Article(2,"Tech Spark 9 pro leaked","Techno spark 9 pro to get 90HZ refresh rate"))
//
//            call.respond(mapOf("articles" to list))
//        }

    }
}

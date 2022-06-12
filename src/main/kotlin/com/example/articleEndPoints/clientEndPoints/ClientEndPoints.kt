package com.example.articleEndPoints.clientEndPoints

import com.example.model.request.RequestStatus
import com.example.model.responses.ResponseMessage
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.clientEndPoints(repository: ClientRepository)
{

    routing()
    {


        /******** get all articles  *******/
        // get all articles
        get("article/getAll")
        {
            call.respond(repository.getAllArticles())
        }



        /******* get article by id ********/

        get ("/article/{id}")
        {

            val id = call.parameters["id"]
            val response = repository.getArticleById(id!!)
            if(response!=null)
            {
                call.respond(response)
            }else
            {

                call.respond(HttpStatusCode.NotFound,ResponseMessage(RequestStatus.FAILED,"No article found"))
            }

        }



    } // routing



} // articleEndPoints

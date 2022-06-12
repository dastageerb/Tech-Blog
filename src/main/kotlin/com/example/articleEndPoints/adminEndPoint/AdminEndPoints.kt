package com.example.articleEndPoints.adminEndPoint

import com.example.data.dbEntities.Article
import com.example.model.request.ArticleRequest
import com.example.model.request.RequestStatus
import com.example.model.responses.ResponseMessage
import com.example.utils.ParseHelper.toCategory
import com.example.utils.ParseHelper.toViewType
import com.example.utils.Validator
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

fun Application.adminEndPoints(repository: AdminRepository)
{

    routing ()
    {


        /******* add Article ********/
        // add an article
        post("/addArticle")
        {
            try {
                val body = call.receive<ArticleRequest>()
                val validator = Validator.validateArticlesInput(body)
                if (validator.valid) {
                    val Article = Article(
                        title = body.title,
                        description = body.description,
                        imageUrl = body.imageUrl,
                        thumbnail = body.thumbnail,
                        viewType = body.viewType?.toViewType(),
                        categoryType = body.categoryType?.toCategory()
                    )
                    call.respond(repository.addArticle(Article))
                } else {
                    call.respond(ResponseMessage(RequestStatus.ERROR, validator.message))
                }
            } catch (e: java.lang.Exception) {
                call.respond(ResponseMessage(RequestStatus.ERROR, "Something Went Wrong"))
            }
        } // post closed


        delete("/article/delete/{id}")
        {
            val id = call.parameters["id"]
            call.respond(repository.deleteArticle(id!!))
        }



    }
} // articleEndPoints

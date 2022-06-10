package com.example.endpoint

import com.example.data.database.entities.Article
import com.example.model.request.ArticleRequest
import com.example.model.request.RequestStatus
import com.example.model.responses.ResponseMessage
import com.example.endpoint.ParseHelper.toCategory
import com.example.endpoint.ParseHelper.toViewType
import com.example.utils.Validator
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

fun Application.articleEndPoints(repository: ArticleRepository)
{

    routing {

        // get all articles

        get("/articles")
        {
            call.respond(repository.getAllArticles())
        }

        // add an article

        post("/addArticle")
        {
            try
            {

                val body = call.receive<ArticleRequest>()

                val validator = Validator.validateArticlesInput(body)

                if (validator.valid)
                {
                    val Article = Article(
                        title = body.title,
                        description = body.description,
                        imageUrl = body.imageUrl,
                        thumbnail = body.thumbnail,
                        viewType = body.viewType?.toViewType(),
                        categoryType = body.categoryType?.toCategory()
                    )
                    call.respond(repository.addArticle(Article))

                }else
                {
                    call.respond(ResponseMessage(RequestStatus.ERROR,validator.message))
                }

            }catch (e:java.lang.Exception)
            {
                call.respond(ResponseMessage(RequestStatus.ERROR,"Something Went Wrong"))
            }

        } // post closed

    }
}

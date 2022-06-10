package com.example.endpoint

import com.example.data.database.models.Article
import com.example.data.database.models.ViewType
import com.example.data.request.ArticleRequest
import com.example.data.request.RequestStatus
import com.example.data.responses.ResponseMessage
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

                if(body.title.isNullOrEmpty())
                {
                    call.respond(ResponseMessage(RequestStatus.ERROR,"title cannot be empty"))
                    return@post
                }else if (body.description.isNullOrEmpty())
                {
                    call.respond(ResponseMessage(RequestStatus.ERROR,"description cannot be empty"))
                    return@post
                }
                else if (body.thumbnail.isNullOrEmpty())
                {
                    call.respond(ResponseMessage(RequestStatus.ERROR,"thumbnail cannot be empty"))
                    return@post
                } else if (body.imageUrl.isNullOrEmpty())
                {
                    call.respond(ResponseMessage(RequestStatus.ERROR,"image cannot be empty"))
                    return@post
                }

                else if (body.viewType == null)
                {
                    call.respond(ResponseMessage(RequestStatus.ERROR,"View type cannot be empty"))
                    return@post
                }else if(!(body.viewType == 0 || body.viewType==1))
                {
                    call.respond(ResponseMessage(RequestStatus.ERROR,"Invalid view type"))
                    return@post
                }

                val viewType = if (body.viewType==0) ViewType.NORMAL else ViewType.IMAGE

                val Article = Article(
                    title = body.title,
                description = body.description,
                imageUrl = body.imageUrl,
                thumbnail = body.thumbnail,
                viewType = viewType)
                call.respond(repository.addArticle(Article))

            }catch (e:java.lang.Exception)
            {
                call.respond(ResponseMessage(RequestStatus.ERROR,"Something Went Wrong"))
            }

        } // post closed

    }
}

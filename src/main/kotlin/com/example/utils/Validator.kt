package com.example.utils

import com.example.model.Validation
import com.example.model.request.ArticleRequest
import io.ktor.server.application.*
import io.ktor.server.response.*

object Validator
{
    
    fun validateArticlesInput(article: ArticleRequest) : Validation
    {
        return if(article.title.isNullOrEmpty())
        {
            Validation(false,"title cannot be empty")
        }else if (article.description.isNullOrEmpty())
        {
            Validation(false,"description cannot be empty")
        }
        else if (article.thumbnail.isNullOrEmpty())
        {
            Validation(false,"thumbnail cannot be empty")
        } else if (article.imageUrl.isNullOrEmpty())
        {
            Validation(false,"image cannot be empty")
        }
        else if (article.categoryType.isNullOrEmpty())
        {
            Validation(false,"category cannot be empty")
        }

        else if (article.viewType == null)
        {
            Validation(false,"View type cannot be empty")
        }else
        {
            Validation(true,"")
        }
    } // validateArticleInput
    
    
    
    
    
    
    
    
}
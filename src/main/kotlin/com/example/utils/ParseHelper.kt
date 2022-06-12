package com.example.utils

import com.example.data.dbEntities.Category
import com.example.data.dbEntities.ViewType

object ParseHelper
{


    // viewType

    fun ViewType.fromViewType() =this.name

    fun String.toViewType() = ViewType.valueOf(this)


    // categoryTyp

    fun Category.fromCategory() = this.name


    fun String.toCategory() = Category.valueOf(this)





}
package com.example.endpoint

import com.example.data.database.entities.Category
import com.example.data.database.entities.ViewType

object ParseHelper
{


    // viewType

    public fun ViewType.fromViewType() =this.name

    public fun String.toViewType() =ViewType.valueOf(this)


    // categoryTyp

    public fun Category.fromCategory() = this.name


    public fun String.toCategory() =Category.valueOf(this)





}
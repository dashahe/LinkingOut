package com.sao.domain.model

data class  News(var title:String, var contents:ArrayList<NewsContent>){

    data class NewsContent(var title:String,var contentUrl:String,var imageUrl:String?)

    override fun toString(): String {
        return "${title} + ${contents.toString()}"
    }
}
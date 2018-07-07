package com.sao.domain.model

//the return value wrapper of NewsCrawler
data class  NewsWrapper(var newsColumnTitle:String,
                        var newsContents:ArrayList<NewsContent>){

    data class NewsContent(var newsContentTitle:String,
                           var contentUrl:String,
                           var imageUrl:String?)

    override fun toString(): String {
        return "${newsColumnTitle} + ${newsContents.toString()}"
    }
}
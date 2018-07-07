package com.sao.service

import com.sao.domain.model.News

interface NewsService{


    //get some news
    fun saveNews()

    //fun news for banner with imageUrl
    fun findBannerNews():Iterable<News>

    //find all news
    fun findAllNews():Iterable<News>

    //find plain news without imageUrl
    fun findPlainNews():Iterable<News>

}
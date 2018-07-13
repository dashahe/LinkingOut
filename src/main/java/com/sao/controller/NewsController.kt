package com.sao.controller

import com.sao.domain.model.News
import com.sao.service.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
@RequestMapping("/news")
class NewsController{

    val newsService :NewsService

    @Autowired
    constructor( newsService: NewsService){
        this.newsService = newsService
    }

    @GetMapping
    @ResponseBody
    fun getNews():Iterable<News>{
        return newsService.findBannerNews()
    }

    //todo
    @GetMapping("/retrieve")
    fun retrieveNews(){
        newsService.saveNews()
    }
}
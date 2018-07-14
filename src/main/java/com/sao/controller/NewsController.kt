package com.sao.controller

import com.sao.domain.model.News
import com.sao.service.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView


@Controller
@RequestMapping("/news")
class NewsController{

    val newsService :NewsService

    @Autowired
    constructor( newsService: NewsService){
        this.newsService = newsService
    }

    @GetMapping
    fun getNews(model: Model):String {
        var list = newsService.findAllNews();
        model.addAttribute("newsList",list);
        return "home"
    }

    //todo
    @GetMapping("/retrieve")
    fun retrieveNews(){
        newsService.saveNews()
    }
}
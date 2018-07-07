package com.sao.service.impl

import com.sao.controller.NewsCrawler
import com.sao.domain.model.News
import com.sao.domain.repository.NewsRepository
import com.sao.service.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NewsServiceimpl:NewsService {


    lateinit var newsRepository: NewsRepository

    @Autowired
    constructor(newsRepository: NewsRepository){
        this.newsRepository = newsRepository
    }

    override fun saveNews() {
        val newsCrawler  = NewsCrawler()
        val newList = newsCrawler.news

        for (newsWrapper in newList){

            val columnTitle = newsWrapper.newsColumnTitle
            var contents = newsWrapper.newsContents

            for(newsContent in contents){
                val news = News()

                //if newsContent.imageUrl not null
                val temp :String? = newsContent.imageUrl

                println("XXXX==="+temp)
                if(temp.equals("")){
                    news.newsType = 0L
                    news.imageUrl = ""
                    println("XXX=="+news.newsType)
                }else{
                    news.imageUrl  = "http://www.ccnu.com.cn${newsContent.imageUrl!!}"
                    news.newsType = 1L
                    println("XXX=="+news.newsType)
                }

                news.contentUrl = "http://www.ccnu.com.cn/${newsContent.contentUrl}"

                news.newsContentTitle = newsContent.newsContentTitle

                news.newsColumn = columnTitle

                newsRepository.save(news)
            }
        }
    }

    override fun findBannerNews(): Iterable<News> {
        val iterable = newsRepository.findAllNews()
        println("ffdf"+iterable)
        var news = News()
        var bannerNews  =ArrayList<News>()
        var counter = 0

        var a :Long = 1
        for(new in iterable){
            println("ffdf"+new.newsType)
            if(compare(a,new.newsType)&&counter<3&&!new.newsColumn.equals("abcd")) {
                counter ++
                bannerNews.add(new)
            }
        }
        println("ffdfd"+bannerNews.asIterable())
        return bannerNews.asIterable()
    }


    override fun findPlainNews(): Iterable<News> {
        val iterable = newsRepository.findAllNews()
        var news = News()
        var plainNews  =ArrayList<News>()
        for(new in iterable){
            if(news.newsType == 0L)
                plainNews.add(news)
        }
        return plainNews.asIterable()
    }


}
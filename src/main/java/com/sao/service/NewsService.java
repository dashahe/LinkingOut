package com.sao.service;

import com.sao.domain.model.News;

public interface NewsService {

    //get some news
    void saveNews();

    //fun news for banner with imageUrl
    Iterable<News> findBannerNews();

    //find plain news without imageUrl
    Iterable<News> findPlainNews();


    default boolean compare(Long a, Long b){
        if(a==null||b==null) return false;

        if(a.intValue() == b.intValue()){
            return true;
        }else{
            return false;
        }
    }
}
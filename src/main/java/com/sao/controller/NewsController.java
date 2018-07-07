package com.sao.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NewsController {

    public void getNews(){

        String responseBody = new String();
        OkHttpClient client = new OkHttpClient();
        Request request  = new Request.Builder().url("http://www.ccnu.com.cn/").build();
        try {
            Response response = client.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(responseBody);
        Elements elements = doc.select("section[class=met-index-two met-index-body]");
//        System.out.println("run"+elements.size());
        //the size of the elements should be one!
        Element baseElement = elements.get(0);

        Element containElement = new Element(Tag.valueOf(baseElement.tagName()),
                baseElement.baseUri(),baseElement.attributes().clone());

        Element rowElement = new Element(Tag.valueOf(containElement.tagName()),
                containElement.baseUri(),containElement.attributes().clone());


      System.out.print(rowElement.className());
    }


    private 
}


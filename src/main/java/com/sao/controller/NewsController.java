package com.sao.controller;

import com.sao.domain.model.News;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Element containElement = baseElement.child(0);

        Element rowElement = containElement.child(0);

        Elements  newsElemets = rowElement.children();
        List<News> newsList = new ArrayList<>();

        for(Element element : newsElemets){

            ArrayList<News.NewsContent> contentList = new ArrayList<>();

            String html = element.html();
            String columnTitleRegex = "((.*)<span>(.*)</span>(.*))";
            Pattern columnTitlePattern = Pattern.compile(columnTitleRegex);
            Matcher columnTitleMatcher = columnTitlePattern.matcher(html);

            String columnTitle = "" ;
            while(columnTitleMatcher.find()){
                columnTitle = columnTitleMatcher.group(3);
            }


            String newsTitleRegex  ="((.*)<h4>(.*)</h4>(.*))";
            Pattern newTitlePattern = Pattern.compile(newsTitleRegex);
            Matcher newTitleMatcher = newTitlePattern.matcher(html);

            String newsContentTitle = "";
            List<String> newsContentTitleList= new ArrayList<>();
            while(newTitleMatcher.find()){
                newsContentTitle = newTitleMatcher.group(3);
                newsContentTitleList.add(newsContentTitle);


            }

            //image may be not exist
            String newsContentImageUrl = "";
            String imageRegex = "(<img class=\"cover-image\" " +
                    "alt=\"(.*)\" src=\"(.*)\">(.*))";
            Pattern imagePattern =  Pattern.compile(imageRegex);
            Matcher imageMatcher = imagePattern.matcher(html);

            List<String> newsUrlImageList = new ArrayList<String>();
            while (imageMatcher.find()){
                newsContentImageUrl = imageMatcher.group(3);
                newsUrlImageList.add(newsContentImageUrl);

            }

            String urlRegex =" ((.*) <a href=\"(.*)\">(.*))";
            Pattern urlPattern = Pattern.compile(urlRegex);
            Matcher urlMatcher = urlPattern.matcher(html);

            List<String> urls = new ArrayList<>();
            while(urlMatcher.find()){
                urls.add(urlMatcher.group(3));
            }

            for(int i=0;i<newsContentTitleList.size();i++) {
                if (i==0) {
                    contentList.add(new News.NewsContent(newsContentTitleList.get(i),newsUrlImageList.get(i) , urls.get(i)));
                }else{
                    contentList.add(new News.NewsContent(newsContentTitleList.get(i),"" , urls.get(i)));
                }
            }

            News news = new News(columnTitle,contentList);

            newsList.add(news);

        }


    }

}


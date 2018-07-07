package com.sao.controller;

import com.google.gson.Gson;
import com.sao.domain.model.NewsWrapper;
import com.sao.utils.TextUtil;
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

public class NewsCrawler {



    public ArrayList<NewsWrapper> getNews(){

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
        ArrayList<NewsWrapper> newsList = new ArrayList<>();

        for(Element element : newsElemets){

            ArrayList<NewsWrapper.NewsContent> contentList = new ArrayList<>();

            String html = element.html();
            String columnTitleRegex = "((.*)<span>(.*)</span>(.*))";
            Pattern columnTitlePattern = Pattern.compile(columnTitleRegex);
            Matcher columnTitleMatcher = columnTitlePattern.matcher(html);

            String columnTitle = "" ;
            while(columnTitleMatcher.find()){
                columnTitle = columnTitleMatcher.group(3);
            }

            columnTitle = getTranslation(columnTitle);


            String newsTitleRegex  ="((.*)<h4>(.*)</h4>(.*))";
            Pattern newTitlePattern = Pattern.compile(newsTitleRegex);
            Matcher newTitleMatcher = newTitlePattern.matcher(html);

            String newsContentTitle = "";
            List<String> newsContentTitleList= new ArrayList<>();
            while(newTitleMatcher.find()){
                newsContentTitle = getTranslation(newTitleMatcher.group(3));
                newsContentTitleList.add(newsContentTitle);

            }

            //image may be not exist
            String newsContentImageUrl = "";
            String imageRegex = "(<img class=\"cover-image\" " +
                    "alt=\"(.*)\" src=\"(.*)\"></a> <a href=\"(.*))";
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
                    contentList.add(new NewsWrapper.NewsContent(newsContentTitleList.get(i),newsUrlImageList.get(i) , urls.get(i)));
                }else{
                    contentList.add(new NewsWrapper.NewsContent(newsContentTitleList.get(i),"" , urls.get(i)));
                }
            }

            NewsWrapper news = new NewsWrapper(columnTitle,contentList);

            newsList.add(news);
        }

        return newsList;
    }


    private String getTranslation(String src){
        String url = TextUtil.Companion.formatUrl(src);
        System.out.println(TextUtil.Companion.formatUrl("中国"));
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        String result = "";
        try {
            String json = client.newCall(request).execute().body().string();
            Gson gson = new Gson();
            TranslateObject object = new TranslateObject();

            object = gson.fromJson(json,TranslateObject.class);
            result = object.getTrans_result().get(0).dst;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    static class TranslateObject{

        /**
         * from : en
         * to : zh
         * trans_result : [{"src":"apple","dst":"苹果"}]
         */

        private String from;
        private String to;
        private List<TransResultBean> trans_result;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public List<TransResultBean> getTrans_result() {
            return trans_result;
        }

        public void setTrans_result(List<TransResultBean> trans_result) {
            this.trans_result = trans_result;
        }

        public static class TransResultBean {
            /**
             * src : apple
             * dst : 苹果
             */

            private String src;
            private String dst;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getDst() {
                return dst;
            }

            public void setDst(String dst) {
                this.dst = dst;
            }
        }
    }
}


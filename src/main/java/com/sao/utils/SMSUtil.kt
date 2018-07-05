package com.sao.utils

import com.sao.CheckSumBuilder
import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.message.BasicNameValuePair
//import org.aspectj.apache.bcel.classfile.annotation.NameValuePair
import java.util.*


class SMSUtil(var mobileNumber:String){
    var SERVER_URL ="https://api.netease.im/sms/sendcode.action"

    var APP_KEY = "d5e97fad58f0b336cdeaf42615e609d0"

    var APP_SECRET="5b588e65c445"

    var NONCE :String = "11fddfdaewda2"

    var TEMPLATED = "3953291"

        var CODELEN = "6"

    fun exec(){

        var defaultHttpClient  = DefaultHttpClient()
        var httpPost = HttpPost(SERVER_URL)


        var current = (Date().time/1000).toString()

        var checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, current)


        httpPost.addHeader("AppKey", APP_KEY);
        httpPost.addHeader("Nonce", NONCE);
        httpPost.addHeader("CurTime", current);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        var npvs = ArrayList<NameValuePair>()
        npvs.add(BasicNameValuePair("templateid",TEMPLATED))
        npvs.add(BasicNameValuePair("mobile",mobileNumber))
        npvs.add(BasicNameValuePair("codeLen",CODELEN))

        httpPost.entity = UrlEncodedFormEntity(npvs, "utf-8")

        var response = defaultHttpClient.execute(httpPost)

        println("checksum "+checkSum )
        println("curtime "+current )

    }

}
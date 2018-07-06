package com.sao.utils

import com.qiniu.common.Zone
import com.qiniu.storage.Configuration
import com.qiniu.storage.UploadManager
import com.qiniu.util.Auth
import java.io.File

class QiniuUtil{

    companion object Companion{

        var QINIU_DOMAIN = "ogbvujd8z.bkt.clouddn.com"
        val accessKey = "W7-6V7W1UycOh9jL9B_pWYSy6W-SwcURAYr_dBIZ"
        val secrectKey = "jagQ78Gqv3m6VNnUetSJ7sgmT2aSJo-9iccFTDU_"

        val auth = Auth.create(accessKey, secrectKey)

        /**
         * if the qiniu generate key failed, the function will return "
         * for result of the key
         */
        fun generateUrl(file: File, destFileName:String,bucket:String):String{
            if(!file.exists()) {
                throw Exception("no local file found")
            }

            val token :String = auth.uploadToken(bucket)
            val z = Zone.zone0()
            val c = Configuration(z)

            val manager = UploadManager(c)
            val res = manager.put(file,destFileName,token)

            if(res.isOK){
                var ret=  res.jsonToObject(Ret::class.java)
                return "ogbvujd8z.bkt.clouddn.com/${ret.key}"
            }
            return ""
        }

    }

    data class Ret(var fsize:Long,
                   var key:String,
                   var hash:String,
                   var width:Int,
                   var height:Int){

    }
}
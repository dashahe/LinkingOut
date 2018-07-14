package com.sao.utils

import com.sao.utils.BASE64Encoder
import java.math.BigInteger
import java.net.URLEncoder
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*



class TextUtil{

    companion object {
        fun formatDate():String{
            var date = Date()
            var simpledataformat = SimpleDateFormat("yy/MM/dd_HH:mm")
            return "${simpledataformat.format(date)}"
        }

        fun getFullUrl(dest:String):String{
            return "http://${dest}"
        }

        fun formatUrl( src:String):String{

            val APP_ID = "20180707000183560"
            val SECRET_KEY = "fMf4uPDm0cnh5_Vq1efJ"
            var q = converToUTF8(src)

                val md5 = MessageDigest.getInstance("MD5")
                val base64en = BASE64Encoder()
                val salt = System.currentTimeMillis()/1000L
                val connect = "${APP_ID}${q}${salt}${SECRET_KEY}"
                val sign = getMD5Str(connect)

                val srcEncoded = URLEncoder.encode(q,"utf-8")

            val returnValue =  "http://api.fanyi.baidu.com/api/trans/vip/translate?q=${srcEncoded}&from=zh&to=en&appid=${APP_ID}" +
                    "&salt=${salt}&sign=${sign}"

            return returnValue

        }


        @Throws(Exception::class)
        fun getMD5Str(str: String): String {
            try {
                // 生成一个MD5加密计算摘要
                val md = MessageDigest.getInstance("MD5")
                // 计算md5函数
                md.update(str.toByteArray())
                // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
                // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
                return BigInteger(1, md.digest()).toString(16)
            } catch (e: Exception) {
                throw Exception("MD5加密出现错误，" + e.toString())
            }

        }


            fun converToUTF8(src:String):String{
            var string = src
            val utf8 = string.toByteArray(charset("UTF-8"))
            string = String(utf8, charset("UTF-8"))
            return string
        }
    }


}
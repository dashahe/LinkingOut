package com.sao.utils

class CookieGenerator{

    companion object {

         fun makeCookie(uid :Long,date:String ):String{
            var cookie :String = "cookie-${date}-${uid}"
            return cookie
        }
    }
}
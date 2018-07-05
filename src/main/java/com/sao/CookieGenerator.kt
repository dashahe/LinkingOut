package com.sao

class CookieGenerator{

    companion object {

         fun makeCookie(uid :Long,date:String ):String{
            var cookie :String = "login_cookie-${date}-${uid}"
            return cookie
        }
    }
}
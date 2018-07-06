package com.sao.utils

import com.sao.domain.model.User
import javax.servlet.http.Cookie

class CookieGenerator(var name:String){

     var created :Long = 0


    /**
     * pass user
     */
    fun makeCookie(user: User): Cookie {
        created = (System.currentTimeMillis())
        var value = this.name + "-${created.toString()}-${user.uid}"
        var cookie = Cookie(name,value)
        return cookie
    }

    fun isExpired() :Boolean{
        var currentTime = System.currentTimeMillis()
        return currentTime > created+30*36000
    }

}
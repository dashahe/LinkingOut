package com.sao.utils

import com.sao.domain.User
import javax.servlet.http.Cookie

class CookieGenerator(var name:String){

     var created :Long = 0


    fun makeCookie(user: User): Cookie {
        created = (System.currentTimeMillis())
        var value = this.name + "-${created.toString()}-${user.uid}"
        var cookie = Cookie(name,value)
        return cookie
    }

    fun isExpired() =  {
        var currentTime = System.currentTimeMillis()
        if(currentTime<=created+30*36000)
            false
        else
            true
    }

}
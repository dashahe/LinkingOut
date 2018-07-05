package com.sao

import javax.servlet.*
import javax.servlet.FilterConfig
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class SkipFilter : Filter {


    override fun destroy() {
    }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
       var httpRequest  =  request as HttpServletRequest
        var httpResponse =  response as HttpServletResponse
        var httpSession = request.session

        var  userCode = request.remoteUser
        var userRole = request.getAttribute("username")

        println("fuck ${userCode} + ${userRole}")
    }


    override fun init(filterConfig: FilterConfig?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
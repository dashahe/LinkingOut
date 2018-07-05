package com.sao.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest


@ControllerAdvice
class GlobalExceptionHandler{

    @ExceptionHandler(value = Exception::class)
    fun defaultErrorHandler( request: HttpServletRequest,e:Exception)
    :ModelAndView{
        var modelView = ModelAndView()
        modelView.addObject("exception",e)
        modelView.addObject("url",request.requestURL)
        modelView.viewName = "error"
        return modelView
    }
}
package com.sao.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        int code = 404;
        String message = "";
        if(e instanceof CException){
            message = ((CException)e).message;
            code = ((CException)e).code;
        }
        mav.addObject("errorCode", code);
        mav.addObject("errorMessage",message);
//        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

}

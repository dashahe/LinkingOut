package com.sao.controller

import com.sao.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse


@Controller
@RequestMapping("/login")
class LoginController{


    var userService :UserService

    @Autowired
    constructor(userService: UserService){
        this.userService = userService
    }


    @GetMapping
    fun getLoginPage():String{
        return "login"
    }


    //todo add post and setcookie.
    //return register
    @PostMapping
    fun login(@RequestParam(name="tel") tel:String,
              @RequestParam(name="password") password:String,
              response: HttpServletResponse):ModelAndView{
        val user = userService.findByTel(tel)

        val modelAndView  = ModelAndView("register")
        var cookie = Cookie("fuck----","fafafa")

        if(user.password.equals(password)){
            response.addCookie(cookie)
            return modelAndView
        }else{
            return modelAndView
        }
    }



}
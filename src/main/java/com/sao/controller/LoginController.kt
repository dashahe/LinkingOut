package com.sao.controller

import com.sao.service.UserService
import com.sao.utils.CookieGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletResponse


@Controller
@RequestMapping("/login")
class LoginController{


    var cookieJar  = HashMap<Int,String>()

    var userService :UserService

    @Autowired
    constructor(userService: UserService){
        this.userService = userService
    }


    @GetMapping
    fun getLoginPage():String{
        return "login"
    }


    //todo should be send to homepage
    @PostMapping
    fun login(@RequestParam(name="tel") tel:String,
              @RequestParam(name="password") password:String,
              response: HttpServletResponse):ModelAndView{
        val user = userService.findByTel(tel)

        val date = System.currentTimeMillis()
        var modelAndView  = ModelAndView("register")
        val cookieGenerator = CookieGenerator(name="login_cookie")
        val cookie = cookieGenerator.makeCookie(user)

        if(user.password.equals(password)&&cookieGenerator.isExpired()){
                response.addCookie(cookie)
                return modelAndView
        }else{
            //todo the frontend end should the answer is wrong
            modelAndView = ModelAndView("login")
            return modelAndView
        }
    }



}
package com.sao.controller

import com.sao.service.UserService
import com.sao.utils.CookieGenerator
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession;


//@Controller
//@RequestMapping("/login")
//class LoginController{
//
//    var cookieJar  = HashMap<Int,String>()
//
//    var userService :UserService
//
//    @Autowired
//    constructor(userService: UserService){
//        this.userService = userService
//    }
//
//
//    @GetMapping
//    fun getLoginPage():String{
//        return "login"
//    }
//
//
//    //todo should be send to homepage
//    @PostMapping
//    fun login(@RequestParam(name="tel") tel:String,
//              @RequestParam(name="password") password:String,
//              response: HttpServletResponse,
//              session: HttpSession):ModelAndView{
//        val user = userService.findByTel(tel)
//
//        val date = System.currentTimeMillis()
//        var modelAndView  = ModelAndView("register")
//        val cookieGenerator = CookieGenerator(name="login_cookie")
//        val cookie = cookieGenerator.makeCookie(user)
//
//        if(user.password.equals(password)&&cookieGenerator.isExpired()){
//            response.addCookie(cookie)
//            session.setAttribute("uid", user.uid);
//            session.setAttribute("tel", user.tel);
//            return modelAndView
//        }else{
//            //todo the frontend end should the answer is wrong
//            modelAndView = ModelAndView("login")
//            return modelAndView
//        }
//    }
//}

@Controller
@RequestMapping("/login")
class LoginController {

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
              response: HttpServletResponse,
              session: HttpSession):String{
        val user = userService.findByTel(tel)

        val date = System.currentTimeMillis()
        //val cookieGenerator = CookieGenerator(name="login_cookie")
        //val cookie = cookieGenerator.makeCookie(user)


//        System.out.print("-------------------login function  ");
//        System.out.print("----- " + tel + password);
        if (user.password.equals(password)) {
            session.setAttribute("uid", user.uid);
            return "redirect:/"
        } else {
            return "login"
        }
    }

}
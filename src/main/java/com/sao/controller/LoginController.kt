package com.sao.controller

import com.sao.domain.User
import com.sao.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


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


    //todo required static resources
    @PostMapping
    fun login(@RequestParam(name="tel") tel:String,
              @RequestParam(name="password") password:String):String{
        var user = userService.findByTel(tel)
        if(user.password.equals(password)){
            return "save"
        }else{
            return "false"
        }
    }



}
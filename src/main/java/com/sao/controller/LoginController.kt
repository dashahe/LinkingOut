package com.sao.controller

import com.sao.domain.User
import com.sao.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
@RequestMapping("/login")
class LoginController{


    var userService :UserService

    @Autowired
    constructor(userService: UserService){
        this.userService = userService
    }

    //todo required static resources
    @PostMapping
    fun login(@RequestBody user : User):String{
        if(userService.findByUsername(user.username!!).password.equals(
                        user.password)){
            return "saved";
        }else{
            return "not saved!"
        }
    }



}
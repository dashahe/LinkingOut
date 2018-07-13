package com.sao.controller

import com.sao.domain.model.User
import com.sao.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("/register")
class RegisterController {

    @Autowired
    lateinit var userService: UserService


    constructor(userService: UserService) {
        this.userService = userService
    }

//    @GetMapping
//    @ResponseBody
//    fun getAllUsers(): Iterable<User> {
//        return userService.findAllUsers()
//    }

    //todo return value and error code
    //test procedure 1.apply error handing -> 2.add some user info ->3.test customized sql
    @PostMapping
    fun register(@RequestParam(name = "username") username: String,
                 @RequestParam(name = "password") password: String,
                 @RequestParam(name = "tel") tel: String,
                 request:HttpServletRequest,
                 response:HttpServletResponse): String {
        var user = User()
        user.username = username
        user.tel = tel
        user.password = password


        //user id new user() or save user???
        userService.insert(user)

        return "login"
    }


    @GetMapping
    fun getRegisterPage(): String {
        return "register"
    }

    //todo the id in the two tables are different
    //result in the different id
    @GetMapping("{id}")
    @ResponseBody
    fun getUser(@PathVariable id: Long): User {

        return userService.findByUid(id)
    }


}
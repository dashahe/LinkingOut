package com.sao.controller

import com.sao.domain.User
import com.sao.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/register")
class RegisterController{

    @Autowired
    lateinit var userService: UserService

    constructor(userRepository: UserService){
        this.userService = userRepository
    }

//    @GetMapping
//    @ResponseBody
//    fun getAllUsers(): Iterable<User> {
//        return userService.findAllUsers()
//    }

    //todo return value and error code
    //test procedure 1.apply error handing -> 2.add some user info ->3.test customized sql
    @PostMapping
    fun register(@RequestParam(name = "username") username:String,
                 @RequestParam(name="password") password:String,
                 @RequestParam (name="tel")tel:String):String {
        var user = User()
        user.username = username
        user.tel = tel
        user.password = password

        userService.insert(user)
        return "login"
    }

//    //todo add response code
//    @PostMapping()
//    fun register(@RequestBody user:User):String {
//        userService.insert(user)
//        return "login"
//    }

    @GetMapping
    fun getRegisterPage():String{
        return "register"
    }

    //todo the id in the two tables are different
    //result in the different id
    @GetMapping("{id}")
    @ResponseBody
    fun getUser(@PathVariable  id:Long):User {
        return userService.findByUid(id)
    }
}
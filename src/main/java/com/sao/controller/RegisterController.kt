package com.sao.controller

import com.sao.domain.Auth
import com.sao.domain.User
import com.sao.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class RegisterController{

    @Autowired
    lateinit var userService: UserService

    constructor(userRepository: UserService){
        this.userService = userRepository
    }

    @GetMapping(path= arrayOf("all"))
    @ResponseBody
    fun getAllUsers(): Iterable<User> {
        return userService.findAllUsers()
    }

    //todo return value and error code
    //test procedure 1.apply error handing -> 2.add some user info ->3.test customized sql
    @RequestMapping(path= arrayOf("register"))
    fun register(@RequestParam email:String, @RequestParam username:String,
                 @RequestParam password:String,@RequestParam tel:String):String {
        var user = User()
        user.email = email
        user.username = username
        user.tel = tel
        user.password = password

        userService.insert(user)
        return "saved"
    }

    //todo add response code
    @PostMapping("register")

    fun register(@RequestBody user:User):String{
        userService.insert(user)
        return "saved"
    }

    //todo the id in the two tables are different
    //result in the different id
    @GetMapping("{id}")
    @ResponseBody
    fun getUser(@PathVariable  id:Long):User{
        return userService.findByUid(id)
    }
}
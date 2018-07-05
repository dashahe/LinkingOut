package com.sao.controller

import com.sao.domain.User
import com.sao.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/register")
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
//    @GetMapping
//    fun register(@RequestParam username:String,
//                 @RequestParam tel:String,
//                 @RequestParam password:String):String {
//        var user = User()
//        user.username = username
//        user.tel = tel
//        user.password = password
//
//        userService.insert(user)
//        return "saved"
//    }

//    //todo add response code
//    @PostMapping
//    fun register(@RequestBody user:User):String{
//        userService.insert(user)
//        return "saved"
//    }

    @PostMapping
    fun register(@RequestParam username:String,
                 @RequestParam tel:String,
                 @RequestParam password:String):String {
        var user = User()
        user.username = username
        user.tel = tel
        user.password = password

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
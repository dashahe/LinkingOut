package com.sao.controller

import com.sao.domain.model.User
import com.sao.exception.CException
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


    /**
     * return code 403 : if the key tel is duplicated
     */
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


        if(userService.existByTel(user.tel.toString())){
            throw CException(403,"user's tel =${user.tel} is replicated")
        }else {
            userService.insert(user)
        }
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
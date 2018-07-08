package com.sao.controller

import com.sao.service.StarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
@RequestMapping("/star")
class StarController{

    var starService  :StarService


    @Autowired
    constructor(starService: StarService){
        this.starService = starService
    }



    //get star page
    //todo require static resources
    @GetMapping
    fun getStarPage():String{
        return "login";
    }

    //todo missing something
    @PostMapping
    fun createStar(@RequestParam(name = "uid") uid :Long,
                   @RequestParam(name="url") url:String){

        starService.createStar(uid,url)
    }
}
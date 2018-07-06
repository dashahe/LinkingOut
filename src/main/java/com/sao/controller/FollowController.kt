package com.sao.controller


import com.sao.service.FollowSerice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/follow")
class FollowController {


    @Autowired
    var followService: FollowSerice


    constructor(followSerive: FollowSerice){
        this.followService = followSerive
    }

    @PostMapping
    fun createFollowRelation( fid :Long ,bfid:Long):String {
        if(followService.ifUserExist(fid = fid, bfid =  bfid)) {
            followService.createFollower(bfid = bfid, fid = fid)
            return "follow relation created"
        }else{
            return "not exist"
        }
    }



}
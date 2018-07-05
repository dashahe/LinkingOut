package com.sao.controller


import com.sao.domain.FollowRelation
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
        var followRelation  = FollowRelation()
        followRelation.bfid = bfid
        followRelation.fid = fid

        followService.createFollower(followRelation = followRelation)

        return "follow relation created"
    }



}
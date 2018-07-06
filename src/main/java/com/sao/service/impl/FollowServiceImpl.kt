package com.sao.service.impl

import com.sao.domain.FollowIdentity
import com.sao.domain.FollowRelation
import com.sao.domain.FollowRepository
import com.sao.domain.UserRepository
import com.sao.service.FollowSerice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FollowServiceImpl:FollowSerice{

    var followRepository :FollowRepository
    var userRepository : UserRepository

    @Autowired
    constructor(followRepository: FollowRepository,userRepository: UserRepository){
        this.followRepository = followRepository
        this.userRepository = userRepository
    }

    override fun ifUserExist(fid: Long, bfid: Long):Boolean{
        var flag1 : Boolean = false
        var flag2 : Boolean = false

        val iterable = userRepository.findAll()
        for(user in iterable){
            if(user.uid == fid)
                flag1  =true
            if(user.uid ==bfid)
                flag2 = true
        }
        return flag1 && flag2
    }

    override fun createFollower(fid: Long, bfid: Long) {
        var followIdentity  =  FollowIdentity()
        followIdentity.bfid = bfid
        followIdentity.fid = fid
        var followRelation = FollowRelation()
        followRelation.followIdentity  = followIdentity
        followRepository.save(followRelation)
    }
}
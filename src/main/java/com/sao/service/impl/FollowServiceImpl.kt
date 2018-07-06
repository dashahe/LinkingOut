package com.sao.service.impl

import com.sao.domain.FollowIdentity
import com.sao.domain.FollowRelation
import com.sao.domain.FollowRepository
import com.sao.service.FollowSerice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FollowServiceImpl:FollowSerice{

   var followRepository :FollowRepository


    @Autowired
    constructor(followRepository: FollowRepository){
        this.followRepository = followRepository
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
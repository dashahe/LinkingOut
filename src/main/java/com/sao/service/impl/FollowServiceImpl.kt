package com.sao.service.impl

import com.sao.domain.FollowRelation
import com.sao.domain.FollowRepository
import com.sao.service.FollowSerice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FollowServiceImpl:FollowSerice{

   lateinit var followRepository :FollowRepository

    @Autowired
    constructor(followRepository: FollowRepository){
        this.followRepository = followRepository
    }

    override fun createFollower(followRelation : FollowRelation) {
        followRepository.save(followRelation)
    }
}
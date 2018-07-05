package com.sao.service

import com.sao.domain.FollowRelation

interface FollowSerice {

    fun createFollower(followRelation:FollowRelation);
}
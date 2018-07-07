package com.sao.domain.repository

import com.sao.domain.model.FollowIdentity
import com.sao.domain.model.FollowRelation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface FollowRepository : CrudRepository<FollowRelation, FollowIdentity>{

}
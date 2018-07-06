package com.sao.domain.model

import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Entity
//todo when register the user will automatically follow himself
class FollowRelation{


    @EmbeddedId
    lateinit var followIdentity : FollowIdentity

}
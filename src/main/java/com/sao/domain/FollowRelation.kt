package com.sao.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
//todo when register the user will automatically follow himself
class FollowRelation{

    @Id
    var fid :Long = 0

    @Id
    var bfid:Long = 0


}
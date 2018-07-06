package com.sao.domain

import java.io.Serializable
import javax.persistence.Embeddable
import javax.validation.constraints.NotNull


@Embeddable
class FollowIdentity : Serializable{

    @NotNull
    var fid:Long =0

    @NotNull
    var bfid:Long = 0
}
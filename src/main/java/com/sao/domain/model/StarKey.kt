package com.sao.domain.model

import java.io.Serializable
import javax.persistence.Embeddable
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


@Embeddable
class StarKey : Serializable{


    @NotNull
    var uid :Long? = null


    @NotEmpty
    var starUrl :String? = null
}
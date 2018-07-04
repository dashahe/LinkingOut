package com.sao.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotEmpty


//Auth table
@Entity
class Auth: BasicModel(){

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    override var  id:Long? =null

    @NotEmpty
    var password:String?=null
}

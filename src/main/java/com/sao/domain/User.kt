package com.sao.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotEmpty


//User table
//User entity

@Entity
class User: BasicModel() {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    override  var id: Long? = null

    @NotEmpty(message = "Username is required.")
    var username: String? = null

    @NotEmpty(message = "Email is required.")
    var email: String? = null

    @NotEmpty(message = "Password is required")
    var password: String?= null

    @NotEmpty(message ="tel is required")
    var tel :String?= null


}

package com.sao.domain

import javax.persistence.*
import javax.validation.constraints.NotEmpty


//User table
//User entity

@Entity
class User: BasicModel() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    override var uid: Long? = null

    @NotEmpty(message = "Username is required.")
    var username: String? = null

    @Column(unique = true)
    @NotEmpty(message ="tel is required")
    var tel :String?= null

    @NotEmpty(message = "Password is required")
    var password: String?= null
}

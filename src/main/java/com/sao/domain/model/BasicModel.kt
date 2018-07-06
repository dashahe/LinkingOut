package com.sao.domain

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BasicModel{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var uid: Long? = null
}

package com.sao.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

//the entity of news table
//news are divided into two kinds : plain without imageUrl and banner news with imageUrl
//the type of plain is *0 and banner news is *1(newsType)

@Entity
class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var nid :Long ? = null

    var imageUrl :String? = null

    var contentUrl :String?= null

    var newsContentTitle :String? =null

    var  newsType : Long?= null

    var newsColumn :String? = null
}
package com.sao.domain.repository

import com.sao.domain.model.News
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface NewsRepository : JpaRepository<News,Long>{

    @Query(value = "select *from news",nativeQuery = true)
    fun findAllNews():Iterable<News>

}
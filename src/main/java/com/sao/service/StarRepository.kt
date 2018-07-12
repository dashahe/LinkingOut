package com.sao.service

import com.sao.domain.model.Star
import com.sao.domain.model.StarKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface StarRepository : JpaRepository<Star, StarKey>{

}
package com.sao.domain.repository

import com.sao.domain.model.News
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface NewsRepository : CrudRepository<News,Long>
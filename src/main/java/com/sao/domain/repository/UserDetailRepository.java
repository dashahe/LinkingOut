package com.sao.domain.repository;

import com.sao.domain.model.UserDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail, Long> {

}
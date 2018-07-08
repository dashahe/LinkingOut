package com.sao.domain.repository;


import com.sao.domain.model.Activity;
import com.sao.domain.model.ActivityUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, ActivityUserId> {

}

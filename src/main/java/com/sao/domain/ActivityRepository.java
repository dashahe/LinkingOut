package com.sao.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}

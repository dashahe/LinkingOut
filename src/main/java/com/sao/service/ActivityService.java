package com.sao.service;

import com.sao.domain.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ActivityService {

    Iterable<Activity> findAllByUid(Long uid);

//    Page<Activity> findActivity(Integer page, Integer size);
}

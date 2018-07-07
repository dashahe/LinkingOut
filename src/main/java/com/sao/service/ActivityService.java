package com.sao.service;

import com.sao.domain.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.LinkedList;
import java.util.List;


public interface ActivityService {

    LinkedList<Activity> findAllByUid(Long uid);

    void addActivity(Activity activity);

    Iterable<Activity> findAll();
//    Page<Activity> findActivity(Integer page, Integer size);
}

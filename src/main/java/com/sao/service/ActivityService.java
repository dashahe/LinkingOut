package com.sao.service;

import com.sao.domain.model.Activity;

import java.util.LinkedList;


public interface ActivityService {

    LinkedList<Activity> findAllByUid(Long uid);

    void addActivity(Activity activity);

    Iterable<Activity> findAll();
//    Page<Activity> findActivity(Integer page, Integer size);

    Iterable<Activity> findAllByType(String type);
}

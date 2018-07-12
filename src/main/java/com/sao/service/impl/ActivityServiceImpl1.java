package com.sao.service.impl;

import com.sao.domain.model.Activity;
import com.sao.domain.repository.ActivityRepository;
import com.sao.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ActivityServiceImpl1 implements ActivityService {

    private ActivityRepository activityRepository;


    @Autowired
    public ActivityServiceImpl1(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public LinkedList<Activity> findAllByUid(Long uid) {
        LinkedList<Activity> result = new LinkedList<>();
        for (Activity activity : activityRepository.findAll()) {
            if (activity.getUid().equals(uid)) {
                result.add(activity);
            }
        }
        return result;
    }

    @Override
    public void addActivity(Activity activity) {
        activityRepository.save(activity);
    }

    @Override
    public Iterable<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Iterable<Activity> findAllByType(String type) {
        LinkedList<Activity> result = new LinkedList<>();
        for (Activity activity : activityRepository.findAll()) {
            if (activity.getType().equals(type)) {
                result.add(activity);
            }
        }
        return result;
    }

//    @Override
//    public Page<Activity> findActivity(Integer page, Integer size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "aid");
//        return activityRepository.findAll(pageable);
//    }
}

package com.sao.service.impl;

import com.sao.domain.Activity;
import com.sao.domain.ActivityRepository;
import com.sao.service.ActivityService;
import javafx.beans.binding.ListBinding;
import javafx.collections.ObservableList;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


@Service
public class ActivityServiceImpl1 implements ActivityService {

    private ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl1(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Iterable<Activity> findAllByUid(Long uid) {
        Iterable<Activity> activities = activityRepository.findAll();
        List<Activity> result = new ListBinding<Activity>() {
            @Override
            protected ObservableList<Activity> computeValue() {
                return null;
            }
        };
        for (Activity activity : activities) {
            if (activity.getUid().equals(uid)) {
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

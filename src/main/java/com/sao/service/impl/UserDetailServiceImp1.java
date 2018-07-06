package com.sao.service.impl;

import com.sao.domain.UserDetail;
import com.sao.domain.UserDetailRepository;
import com.sao.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp1 implements UserDetailService {

    private UserDetailRepository userDetailRepository;

    @Autowired
    public UserDetailServiceImp1(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public UserDetail findByUid(Long uid) {
        if (userDetailRepository.findById(uid).isPresent()) {
            return userDetailRepository.findById(uid).get();
        } else {
            return null;
        }
    }

    @Override
    public Iterable<UserDetail> findAll() {
        return userDetailRepository.findAll();
    }

    @Override
    public void updateEmailByUid(Long uid, String String) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setEmail(String);
        }
    }

    @Override
    public void updateUniversityByUid(Long uid, String university) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setUniversity(university);
        }
    }

    @Override
    public void updateMajorByUid(Long uid, String major) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setMajor(major);
        }
    }

    @Override
    public void updateHobbyByUid(Long uid, String hobby) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setHobby(hobby);
        }
    }

    @Override
    public void updateImageByUid(Long uid, String image) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setImage(image);
        }
    }
}

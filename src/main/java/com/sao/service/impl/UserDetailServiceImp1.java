package com.sao.service.impl;

import com.sao.domain.model.UserDetail;
import com.sao.domain.repository.UserDetailRepository;
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
    public void updateEmailByUid(Long uid, String email) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setEmail(email);
            userDetailRepository.save(userDetail);
        }
    }

    @Override
    public void updateUniversityByUid(Long uid, String university) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setUniversity(university);
            userDetailRepository.save(userDetail);
        }
    }

    @Override
    public void updateMajorByUid(Long uid, String major) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setMajor(major);
            userDetailRepository.save(userDetail);
        }
    }

    @Override
    public void updateHobbyByUid(Long uid, String hobby) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setHobby(hobby);
            userDetailRepository.save(userDetail);
        }
    }

    @Override
    public void updateImageByUid(Long uid, String image) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setImage(image);
            userDetailRepository.save(userDetail);
        }
    }

    @Override
    public void updateSexByUid(Long uid, String sex) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setSex(sex);
            userDetailRepository.save(userDetail);
        }
    }

    @Override
    public void updateIntroductionByUid(Long uid, String introduction) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setIntroduction(introduction);
            userDetailRepository.save(userDetail);
        }
    }

    @Override
    public void updateAvatartByUid(Long uid, String avatarUrl) {
        UserDetail userDetail = findByUid(uid);
        if (userDetail != null) {
            userDetail.setImage(avatarUrl);
            userDetailRepository.save(userDetail);
        }
    }
}

package com.sao.service;

import com.sao.domain.model.UserDetail;

public interface UserDetailService {

    UserDetail findByUid(Long uid);

    Iterable<UserDetail> findAll();

    void updateEmailByUid(Long uid, String email);

    void updateUniversityByUid(Long uid, String university);

    void updateMajorByUid(Long uid, String major);

    void updateHobbyByUid(Long uid, String hobby);

    void updateImageByUid(Long uid, String image);

    void updateSexByUid(Long uid, String sex);

    void updateIntroductionByUid(Long uid, String introduction);
}

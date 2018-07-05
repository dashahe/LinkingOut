package com.sao.service;

import com.sao.domain.UserDetail;

public interface UserDetailService {

    public UserDetail findByUid(Long uid);

    public Iterable<UserDetail> findAll();

    public void updateEmailByUid(Long uid, String email);

    public void updateCidByUid(Long uid, Long cid);

    public void updateMajorByUid(Long uid, String major);

    public void updateHobbyByUid(Long uid, String hobby);

    public void updateImageByUid(Long uid, String image);
}

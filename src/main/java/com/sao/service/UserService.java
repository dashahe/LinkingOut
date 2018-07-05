package com.sao.service;

import com.sao.domain.User;

public interface UserService {
    void insert(User user);

    User findByUid(Long uid);

    Iterable<User> findAllUsers();

    User findByTel(String tel);

    boolean existByTel(String tel);

    boolean existByUid(Long uid);
}

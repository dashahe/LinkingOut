package com.sao.service.impl;

import com.sao.domain.User;
import com.sao.domain.UserRepository;
import com.sao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl1 implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl1(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUid(Long uid) {
        if (userRepository.findById(uid).isPresent()) {
            return userRepository.findById(uid).get();
        } else {
            return null;
        }
    }

    @Override
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean existByTel(String tel) {
        for (User user : findAllUsers()) {
            if (user.getTel() != null && user.getTel().equals(tel)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByTel(String tel) {
        User result = null;
        for (User user : findAllUsers()) {
            if (user.getTel() != null && user.getTel().equals(tel)) {
                result = user;
            }
        }
        return result;
    }

    @Override
    public boolean existByUid(Long uid) {
        return userRepository.findById(uid).isPresent();
    }
}

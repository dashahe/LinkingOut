package com.sao.controller;

import com.sao.domain.model.User;
import com.sao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class AngularController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public HashMap<Long, User> getUserList(){
        HashMap<Long, User> userHashMap = new HashMap<>();
        Iterable<User> users = userService.findAllUsers();
        for (User user : users) {
            userHashMap.put(user.getUid(), user);
        }
        return userHashMap;
    }
}

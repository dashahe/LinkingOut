package com.sao.controller;

import com.sao.service.ActivityService;
import com.sao.service.UserDetailService;
import com.sao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backend/data")
public class BackendDataController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private UserService userService;

    public BackendDataController(ActivityService activityService,
                                 UserDetailService userDetailService,
                                 UserService userService) {
        this.activityService = activityService;
        this.userDetailService = userDetailService;
        this.userService = userService;
    }

    @GetMapping("/activity")
    public String getActivityData(Model model) {
        model.addAttribute("ActivityList", activityService.findAll());
        return "activity_data";
    }

    @GetMapping("/userdetail")
    public String getUserDetailData(Model model) {
        model.addAttribute("UserDetailList", userDetailService.findAll());
        return "userdetail_data";
    }

    @GetMapping("/user")
    public String getUserData(Model model) {
        model.addAttribute("UserList", userService.findAllUsers());
        return "user_data";
    }
}

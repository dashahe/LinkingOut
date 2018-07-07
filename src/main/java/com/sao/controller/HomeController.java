package com.sao.controller;

import com.sao.domain.model.Activity;
import com.sao.domain.model.UserDetail;
import com.sao.service.ActivityService;
import com.sao.service.UserDetailService;
import com.sao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailService userDetailService;


    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public String addActivity(@RequestParam(name = "content") String content,
                       HttpSession session) {
        Long uid = Long.valueOf(session.getAttribute("uid").toString());
        Activity activity = new Activity();
        activity.setUid(uid);
        activity.setContent(content);
        activity.setCreated(new Date());
        activity.setLikes(new Long(0));
        activityService.addActivity(activity);
        return "home";
    }
}

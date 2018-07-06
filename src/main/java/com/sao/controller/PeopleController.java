package com.sao.controller;

import com.sao.domain.Activity;
import com.sao.domain.UserDetail;
import com.sao.service.ActivityService;
import com.sao.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@75("/people")
public class PeopleController {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private ActivityService activityService;

    public PeopleController(UserDetailService userDetailService,
                            ActivityService activityService) {
        this.userDetailService = userDetailService;
        this.activityService = activityService;
    }

    @RequestMapping("/all")
    @ResponseBody
    public Iterable<UserDetail> all() {
        return userDetailService.findAll();
    }

    @GetMapping("/{uid}/activities")
    public String getActivities(Model model,
                               @PathVariable(name = "uid") Long uid) {
        if (userDetailService.findByUid(uid) == null) {
            return "error";
        }
        Iterable<Activity> activities = activityService.findAllByUid(uid);
        UserDetail userDetail = userDetailService.findByUid(uid);
        model.addAttribute( "activities", activities);
        model.addAttribute("userDetail", userDetail);
        return "activities";
    }

    @GetMapping("/{uid}/edit")
    public String getEdit(Model model, @PathVariable(name = "uid") Long uid) {
        UserDetail userDetail = userDetailService.findByUid(uid);
        model.addAttribute("userDetail", userDetail);
        return "edit";
    }

    @PostMapping("/{uid}/edit")
    public String postEdit(Model model,
                           @PathVariable(name = "uid") Long uid,
                           @RequestParam(name = "email", required = false) String email,
                           @RequestParam(name = "university", required = false) String university,
                           @RequestParam(name = "major", required = false) String major,
                           @RequestParam(name = "hobby", required = false) String hobby,
                           @RequestParam(name = "image", required = false) String image) {
        userDetailService.updateEmailByUid(uid, email);
        userDetailService.updateUniversityByUid(uid, university);
        userDetailService.updateMajorByUid(uid, major);
        userDetailService.updateHobbyByUid(uid, hobby);
        userDetailService.updateImageByUid(uid, image);
        UserDetail userDetail = userDetailService.findByUid(uid);
        model.addAttribute("email", userDetail.getEmail());
        model.addAttribute("university", userDetail.getUniversity());
        model.addAttribute("major", userDetail.getMajor());
        model.addAttribute("hobby", userDetail.getHobby());
        model.addAttribute("image", userDetail.getImage());
        return "edit";
    }
}

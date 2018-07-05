package com.sao.controller;

import com.sao.domain.UserDetail;
import com.sao.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private UserDetailService userDetailService;

    public PeopleController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @RequestMapping("/all")
    public @ResponseBody Iterable<UserDetail> all() {
        return userDetailService.findAll();
    }

    @GetMapping("/{uid}/activities")
    public String getActivities(Model model,
                               @PathVariable(name = "uid") Long uid) {
        //TODO(finish it)
        model.addAttribute(uid);
        return "activities";
    }

    @GetMapping("/{uid}/edit")
    public String getEdit(Model model, @PathVariable(name = "uid") Long uid) {
        UserDetail userDetail = userDetailService.findByUid(uid);
        model.addAttribute("email", userDetail.getEmail());
        model.addAttribute("cid", userDetail.getCid());
        model.addAttribute("major", userDetail.getMajor());
        model.addAttribute("hobby", userDetail.getHobby());
        model.addAttribute("image", userDetail.getImage());
        return "edit.html";
    }

    @PostMapping("/{uid}/edit")
    public String postEdit(Model model,
                           @PathVariable(name = "uid") Long uid,
                           @RequestParam(name = "email", required = false) String email,
                           @RequestParam(name = "cid", required = false) Long cid,
                           @RequestParam(name = "major", required = false) String major,
                           @RequestParam(name = "hobby", required = false) String hobby,
                           @RequestParam(name = "image", required = false) String image) {
        userDetailService.updateEmailByUid(uid, email);
        userDetailService.updateCidByUid(uid, cid);
        userDetailService.updateMajorByUid(uid, major);
        userDetailService.updateHobbyByUid(uid, hobby);
        userDetailService.updateImageByUid(uid, image);
        UserDetail userDetail = userDetailService.findByUid(uid);
        model.addAttribute("email", userDetail.getEmail());
        model.addAttribute("cid", userDetail.getCid());
        model.addAttribute("major", userDetail.getMajor());
        model.addAttribute("hobby", userDetail.getHobby());
        model.addAttribute("image", userDetail.getImage());
        return "edit.html";
    }
}

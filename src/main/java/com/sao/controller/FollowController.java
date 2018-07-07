package com.sao.controller;


import com.sao.domain.model.User;
import com.sao.domain.model.UserDetail;
import com.sao.service.FollowRelationshipService;
import com.sao.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;

@Controller
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    private FollowRelationshipService followRelationshipService;

    @Autowired
    private UserDetailService userDetailService;

    /**
     * 处理我的粉丝界面，查询所有的粉丝的user detail保存在list中。
     * 使用userDetailList渲染thymeleaf模板。
     * @param model
     * @param uid
     * @return
     */
    @GetMapping("/{uid}/myfollow")
    public String getAllFans(Model model, @PathVariable(name = "uid") Long uid) {
        Iterable<User> myFansList = followRelationshipService.findAllFansByUid(uid);
        LinkedList<UserDetail> userDetailLinkedList = new LinkedList<>();
        for (User user : myFansList) {
            userDetailLinkedList.add(userDetailService.findByUid(user.getUid()));
        }
        model.addAttribute("userDetailList", userDetailLinkedList);
        return "myfollow";
    }

    /**
     * 处理我的关注界面，查询所有的关注的user detail保存在list中。
     * 使用userDetailList渲染thymeleaf模板。
     * @param uid
     * @return
     */
    @GetMapping("/{uid}/follow")
    public String getAllStars(Model model, @PathVariable(name = "uid") Long uid) {
        Iterable<User> myStarList = followRelationshipService.findAllStarByUid(uid);
        LinkedList<UserDetail> userDetailLinkedList = new LinkedList<>();
        for (User user : myStarList) {
            userDetailLinkedList.add(userDetailService.findByUid(user.getUid()));
        }
        model.addAttribute("userDetailList", userDetailLinkedList);
        return "follow";
    }
}

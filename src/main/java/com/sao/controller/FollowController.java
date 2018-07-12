package com.sao.controller;


import com.sao.domain.model.User;
import com.sao.domain.model.UserDetail;
import com.sao.service.FollowRelationshipService;
import com.sao.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collection.*;

@Controller
@RequestMapping("/")
public class FollowController {
    @Autowired
    private FollowRelationshipService followRelationshipService;

    @Autowired
    private UserDetailService userDetailService;



    /**
     * 处理我的粉丝界面，查询所有的粉丝的user detail保存在list中。
     * 使用userDetailList渲染thymeleaf模板。
     * @param model
     * @return
     */
    @GetMapping("/fans")
    public String getAllFans(Model model,
                             HttpSession httpSession) {
        Long uid = Long.valueOf(httpSession.getAttribute("uid").toString());
        Iterable<User> myFansList = followRelationshipService.findAllFansByUid(uid);
        LinkedList<UserDetail> userDetailLinkedList = new LinkedList<>();
        for (User user : myFansList) {
            userDetailLinkedList.add(userDetailService.findByUid(user.getUid()));
        }
        model.addAttribute("userDetailList", userDetailLinkedList);
        return "fans";
    }

    /**
     * 处理我的关注界面，查询所有的关注的user detail保存在list中。
     * 使用userDetailList渲染thymeleaf模板。
     * @param model
     * @return
     */
    @GetMapping("/follow")
    public String getAllStars(Model model,
                              HttpSession httpSession) {
        Long uid = Long.valueOf(httpSession.getAttribute("uid").toString());
        Iterable<User> myStarList = followRelationshipService.findAllStarByUid(uid);
        LinkedList<UserDetail> userDetailLinkedList = new LinkedList<>();
        for (User user : myStarList) {
            userDetailLinkedList.add(userDetailService.findByUid(user.getUid()));
        }
        model.addAttribute("userDetailList", userDetailLinkedList);
        return "follow";
    }

    /**
     * 处理我的粉丝界面，查询所有的粉丝的user detail保存在list中。
     * 使用userDetailList渲染thymeleaf模板。
     * @param model
     * @param uid
     * @return
     */
    @GetMapping("/fans/{uid}")
    public String getAllFans(Model model, @PathVariable(name = "uid") Long uid) {
        Iterable<User> myFansList = followRelationshipService.findAllFansByUid(uid);
        LinkedList<UserDetail> userDetailLinkedList = new LinkedList<>();
        for (User user : myFansList) {
            userDetailLinkedList.add(userDetailService.findByUid(user.getUid()));
        }
        model.addAttribute("userDetailList", userDetailLinkedList);
        return "fans";
    }

    /**
     * 处理我的关注界面，查询所有的关注的user detail保存在list中。
     * 使用userDetailList渲染thymeleaf模板。
     * @param uid
     * @return
     */
    @GetMapping("/follow/{uid}")
    public String getAllStars(Model model, @PathVariable(name = "uid") Long uid) {
        Iterable<User> myStarList = followRelationshipService.findAllStarByUid(uid);
        LinkedList<UserDetail> userDetailLinkedList = new LinkedList<>();
        for (User user : myStarList) {
            userDetailLinkedList.add(userDetailService.findByUid(user.getUid()));
        }
        model.addAttribute("userDetailList", userDetailLinkedList);
        return "follow";
    }

    /**
     * 处理加关注功能，前端发送过来POST请求，表单格式带上name为staruid的参数（待关注人的uid）
     * 返回JSON格式数据，只有一个name为"result"的value。success/fail表示处理结果。
     * @param httpSession
     * @param staruid
     * @return
     */
    @PostMapping("/follow/process")
    @ResponseBody
    public HashMap<String, String> processFollow(HttpSession httpSession,
                                                 @RequestParam(name = "staruid") Long staruid) {
        Long fansuid = Long.valueOf(httpSession.getAttribute("uid").toString());
        followRelationshipService.addFollowRelationship(fansuid, staruid);
        HashMap<String, String> result = new HashMap<>();
        if (followRelationshipService.existRelationship(fansuid, staruid)) {
            result.put("result", "success");
        } else {
            result.put("result", "fail");
        }
        return result;
    }
}

package com.sao.controller;

import com.sao.domain.model.User;
import com.sao.domain.model.UserDetail;
import com.sao.service.FollowRelationshipService;
import com.sao.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.LinkedList;

@Controller
@RequestMapping("/recommend")
public class FriendsController {
    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private FollowRelationshipService followRelationshipService;

    @RequestMapping
    public String getFriends(HttpSession httpSession,
                             Model model) {
        Long uid = Long.valueOf(httpSession.getAttribute("uid").toString());
        LinkedList<UserDetail> userDetailList = new LinkedList<>();
        Iterable<User> users = followRelationshipService.findAllStarByUid(uid);
        HashSet<Long> starUids = new HashSet<>();

        for (User user : users) {
            starUids.add(user.getUid());
        }
        for (UserDetail userDetail : userDetailService.findAll()) {
            if (!starUids.contains(userDetail.getUid())) {
                userDetailList.add(userDetail);
            }
        }
        model.addAttribute("userDetailList", userDetailList);
        return "friend_recommend";
    }
}

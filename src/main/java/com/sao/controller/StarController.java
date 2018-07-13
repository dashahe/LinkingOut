package com.sao.controller;


import com.sao.domain.model.Activity;
import com.sao.domain.model.StarRelationship;
import com.sao.service.ActivityService;
import com.sao.service.StarRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;

@Controller
@RequestMapping("/star")
public class StarController {

    @Autowired
    StarRelationshipService starRelationshipService;

    @Autowired
    ActivityService activityService;

    @GetMapping
    public String getStar(Model model, HttpSession httpSession) {
        Long uid = Long.valueOf(httpSession.getAttribute("uid").toString());
        LinkedList<Activity> activities = new LinkedList<>();
        for (StarRelationship starRelationship : starRelationshipService.findAllByUid(uid)) {
            activities.add(activityService.findByAid(starRelationship.getAid()));
        }
        model.addAttribute("activities", activities);
        return "star";
    }

    @PostMapping
    @ResponseBody
    public String starAction(HttpSession httpSession,
                             @RequestParam(name = "aid") Long aid) {
        Long uid = Long.valueOf(httpSession.getAttribute("uid").toString());
        if (!starRelationshipService.existStarRelationship(uid, aid)) {
            starRelationshipService.addStarRelationship(uid, aid);
        }
        if (starRelationshipService.existStarRelationship(uid, aid)) {
            return "success";
        } else {
            return "fail";
        }
    }
}

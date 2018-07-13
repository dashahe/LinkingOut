package com.sao.controller;

import com.sao.domain.model.Activity;
import com.sao.domain.model.News;
import com.sao.domain.model.StarRelationship;
import com.sao.domain.model.UserDetail;
import com.sao.service.*;
import org.hibernate.criterion.LikeExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;

@Controller
@RequestMapping("/")
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private StarRelationshipService starRelationshipService;

    @GetMapping
    public String home(Model model, HttpSession httpSession) {
        Long uid = Long.valueOf(httpSession.getAttribute("uid").toString());
        Iterable<News> news = newsService.findBannerNews();
        LinkedList<Activity> activities = new LinkedList<>();
        for (Activity activity : activityService.findAll()) {
            activities.add(activity);
        }

        LinkedList<Activity> activitiesReverse = new LinkedList<>();
        while (activities.size() != 0) {
            activitiesReverse.push(activities.pop());
        }

        HashSet<Long> starredAids = new HashSet<>();
        for (StarRelationship starRelationship : starRelationshipService.findAllByUid(uid)) {
            starredAids.add(starRelationship.getAid());
        }
        for (Activity activity : activitiesReverse) {
            if (starredAids.contains(activity.getAid())) {
                activity.setStarred(true);
            } else {
                activity.setStarred(false);
                System.out.println(activity.getContent());
            }
        }

        LinkedList<Activity> activitiesRC = new LinkedList<>();
        LinkedList<Activity> activitiesES = new LinkedList<>();
        LinkedList<Activity> activitiesZP = new LinkedList<>();
        LinkedList<Activity> activitiesJZ = new LinkedList<>();

        for (Activity activity : activitiesReverse) {
            if (activity.getType() == null) {
                continue;
            }
            if (activity.getType().equals("rc")) {
                activitiesRC.add(activity);
            } else if (activity.getType().equals("es")) {
                activitiesES.add(activity);
            } else if (activity.getType().equals("zp")) {
                activitiesZP.add(activity);
            } else if (activity.getType().equals("jz")) {
                activitiesJZ.add(activity);
            }
        }

        model.addAttribute("news", news);
        model.addAttribute("activitiesRC", activitiesRC);
        model.addAttribute("activitiesES", activitiesES);
        model.addAttribute("activitiesZP", activitiesZP);
        model.addAttribute("activitiesJZ", activitiesJZ);
        return "home";
    }

    @PostMapping
    public String addActivity(@RequestParam(name = "content") String content,
                       @RequestParam(name = "title") String title,
                       @RequestParam(name = "type") String type,
                       HttpSession session) {
        Long uid = Long.valueOf(session.getAttribute("uid").toString());
        Activity activity = new Activity();
        activity.setUid(uid);
        activity.setContent(content);
        activity.setCreated(new Date());
        activity.setLikes(new Long(0));
        activity.setTitle(title);
        activity.setType(type);
        activityService.addActivity(activity);

        logger.info("--------------------- add activity");
        logger.info("uid:" + uid);
        logger.info("content" + uid);

        return "home";
    }
}

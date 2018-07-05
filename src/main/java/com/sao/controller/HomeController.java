package com.sao.controller;

import com.sao.domain.User;
import com.sao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public String login(@RequestParam(name = "tel") String tel,
                        @RequestParam(name = "password") String password) {
        if (userService.existByTel(tel)) {
            User user = userService.findByTel(tel);
            if (user.getPassword() != null && user.getPassword().equals(password)) {
                return "home";
            } else {
                return "login";
            }
        } else {
            return "register";
        }
    }
}

package com.sao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller("/logout")
public class LogoutController {

    @RequestMapping
    public String logout(HttpSession httpSession) {
        if (httpSession.getAttribute("uid") != null) {
            httpSession.setAttribute("uid", null);
        }
        return "redirect:/";
    }
}
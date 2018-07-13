package com.sao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    /**
     * 接受POST或者GET请求，不带参数。完事后重定向到登陆界面。
     * @param httpSession
     * @return
     */
    @RequestMapping
    public String logout(HttpSession httpSession) {
        if (httpSession.getAttribute("uid") != null) {
            httpSession.setAttribute("uid", null);
        }
        return "redirect:/login";
    }
}

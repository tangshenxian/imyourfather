package com.shenxian.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: immor
 * @Date: 2021/5/12
 */
@Controller
public class LoginController {

    @GetMapping("/user/login")
    public String login(@RequestParam(name = "username", required = false) String username,
                        @RequestParam(name = "password", required = false) String password,
                        HttpSession session,
                        RedirectAttributes model) {
        if (StringUtils.isNotBlank(username) && StringUtils.equals("admin", password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/home/index";
        }
        model.addFlashAttribute("msg", "用户名或密码错误");
        return "redirect:/login";
    }

    @GetMapping("/user/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        request.getSession().removeAttribute("loginUser");
        return "login";
    }
}

package com.shenxian.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Author: immor
 * @Date: 2021/5/12
 */
@Controller
public class LoginController {

    @GetMapping("/user/login")
    public String login(@RequestParam(name = "username", required = false) String username,
                        @RequestParam(name = "password", required = false) String password,
                        RedirectAttributes model) {
        if (StringUtils.equals("admin", username) && StringUtils.equals("admin", password)) {
            return "redirect:/home/index";
        }
        model.addFlashAttribute("msg", "用户名或密码错误");
        return "redirect:/login";
    }
}

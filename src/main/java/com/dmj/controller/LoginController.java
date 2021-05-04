package com.dmj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){
        //具体的业务：判断用户名密码是否正确。isEmpty已经失效，可使用hasText或者hasLength,并且去掉StringUtils之前的否定判断
        if (StringUtils.hasText(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);//登录成功，session中就存在loginUser
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }
}

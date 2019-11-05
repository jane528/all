package com.jane.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.aspectj.lang.ProceedingJoinPoint;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/userlist")
    public String userlist(Model model){
        model.addAttribute("name","jane.wong");
        return "/user/userlist";
    }


}

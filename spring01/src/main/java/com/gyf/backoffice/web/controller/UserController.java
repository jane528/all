package com.gyf.backoffice.web.controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("list")
    public String list(){
        return "/user/userlist";
    }

    @RequestMapping("/login")
    public String login(){
        return "/login/login";
    }

    @RequestMapping("/logincl2222")
    public String logincl(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return "/user/userlist";
    }
    @RequestMapping("logincl122222")
    public String logincl1(Model model){
        List<User> list = new ArrayList<User>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("王小二");
        user1.setPassword("123456");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("王小二");
        user2.setPassword("123456");

        User user3 = new User();
        user3.setId(3);
        user3.setUsername("王小二");
        user3.setPassword("123456");

        list.add(user1);
        list.add(user2);
        list.add(user3);
        model.addAttribute("userlist",list);
        return "/user/userlist";
    }

    @RequestMapping("edit")
    public String edit(int id,Model model){
        System.out.println(id);
        System.out.println(model.getClass());
        User user = new User();
        user.setId(1);
        user.setUsername("王小二");
        user.setPassword("1234567890");

        model.addAttribute("user",user);
        return "/user/edit";
    }

    @RequestMapping("save")
    public String save(User user){
        System.out.println(user);
        return "forward:logincl1";
    }

}

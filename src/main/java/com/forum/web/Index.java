package com.forum.web;

import com.forum.entity.User;
import com.forum.service.ManageUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ManageUserService manageUserService;

    @RequestMapping("/")
    public String welcome(){
        return "index";
    }

    @RequestMapping("/login")
    public String userLogin(){
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

}

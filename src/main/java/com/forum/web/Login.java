package com.forum.web;

import com.forum.dto.UserInfo;
import com.forum.dto.UserRegisterInfo;
import com.forum.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/start")
public class Login {
    @Autowired
    private ManageUserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        Model model, HttpServletRequest request) {
        UserInfo user = userService.userLogin(userName, password);
        if (user!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("userType", user.getUserType());
            if (user.getUserType() == 1){
                // 当用户类型为管理员用户时，
                return "redirect:/admin/main";
            }
            return "redirect:/user/main";
        } else {
            model.addAttribute("message", "登录失败，账号或密码错误！");
            return "error";
        }
    }

    @RequestMapping("/register")
    public String register(UserRegisterInfo userRegisterInfo, Model model){
        boolean succeess = userService.userRegister(userRegisterInfo);
        if (succeess == true) {
            return "redirect:/login";
        } else {
            model.addAttribute("message", "注册失败！该用户名已存在！");
            return "error";
        }
    }

}

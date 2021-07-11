package com.team_three.project.controller;


import com.baomidou.mybatisplus.activerecord.Model;
import com.team_three.project.entity.User;
import com.team_three.project.service.UserService;

import com.team_three.project.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private UserService service;
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, ModelMap modelMap){
        User userDB = service.findByUserName(user.getUserName());
        if (userDB == null) {
            return "redirect:fail.jsp";
        }else if (userDB !=null && userDB.getUserPassword().equals(user.getUserPassword())){

            modelMap.addAttribute("login_success",userDB);
            System.out.println(userDB.getUserStatus());
            return "/index.jsp";
        } else {
            modelMap.addAttribute("login_success",userDB);
            return "fail.jsp";
        }
    }
//    @RequestMapping(value = "/logout",method = RequestMethod.GET)
//    public String logout(User user){
//        service.Logout(user.getUserName());
//        return "redirect:login.jsp";
//    }
}


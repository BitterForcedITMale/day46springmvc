package com.itheima.controller;


import com.itheima.exception.BusinessException;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/queryUser")
    public String queryUser(){
        System.out.println("queryUser...");
        try {
            userService.queryUser();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(222, "查询用户异常");
        }

        return "success";
    }
}

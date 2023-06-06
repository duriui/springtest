package com.spring.autowired.controller;

import com.spring.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-19:51
 */

@Controller  //完成相关bean创建
public class UserController {

    //注入service
    // 第一种方式：属性注入
//    @Autowired  //根据类型找到对应对象，完成注入
//    private UserService userService;

    // 第二种方式：set注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    // 第三种方式：构造方法注入
    private UserService userService;

    @Autowired   //根据类型进行匹配    联合@Qualifier注入，支持按名称注入

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add(){
        System.out.println("controller........");
        userService.add();
    }
}
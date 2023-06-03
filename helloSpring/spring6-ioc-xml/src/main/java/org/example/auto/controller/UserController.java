package org.example.auto.controller;

import org.example.auto.service.UserService;
import org.example.auto.service.UserServiceImpl;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-13:13
 */
public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller方法执行了");
        //调用service的方法
        userService.addUserService();
//        UserService userService = new UserServiceImpl();
//        userService.addUserService();
    }
}

package org.example.resource.controller;

import jakarta.annotation.Resource;
import org.example.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-19:51
 */

@Controller(value = "MyUserController")  //完成相关bean创建
public class UserController {


    /**
     * @Resource  默认根据名称进行匹配，未指定name时，使用属性名作为name，通过name找不到的话自动启动通过类型byType装配
     */
    @Resource(name = "myUserService")
    private UserService userService;

    public void add(){
        System.out.println("controller........");
        userService.add();
    }
}

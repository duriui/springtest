package com.spring;

import com.spring.bean.AnnotationApplicationContext;
import com.spring.bean.ApplicationContext;
import com.spring.service.UserService;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationApplicationContext("com.spring");
        UserService userService = (UserService) context.getBean(UserService.class);
        userService.add();
        System.out.println(userService);
    }
}
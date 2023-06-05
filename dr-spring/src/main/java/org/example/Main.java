package org.example;

import org.example.bean.AnnotationApplicationContext;
import org.example.bean.ApplicationContext;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationApplicationContext("org.example");
        UserService userService = (UserService) context.getBean(UserService.class);
        userService.add();
        System.out.println(userService);
    }
}
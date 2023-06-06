package com.spring.auto;

import com.spring.auto.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-13:46
 */
public class TestUser {

    @Test
    public void testUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_auto.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.addUser();
    }
}

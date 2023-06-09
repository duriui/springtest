package org.example.autowired;

import org.example.autowired.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-20:03
 */
public class TestUserController {

    @Test
    public void testUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.add();
    }
}

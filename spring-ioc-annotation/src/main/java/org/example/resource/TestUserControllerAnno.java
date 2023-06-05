package org.example.resource;

import org.example.config.SpringConfig;
import org.example.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-05-0:09
 */
public class TestUserControllerAnno {

    @Test
    public void testUserAn(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController myUserController = context.getBean("MyUserController", UserController.class);
        myUserController.add();
    }
}

package com.spring.resource;

import com.spring.resource.controller.UserController;
import com.spring.config.SpringConfig;
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

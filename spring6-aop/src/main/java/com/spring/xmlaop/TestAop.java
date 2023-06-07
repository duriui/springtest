package com.spring.xmlaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator bean = context.getBean(Calculator.class);
        bean.div(2,1);
    }
}

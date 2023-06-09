package com.springjdbc.tx.config;


import com.springjdbc.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {

    @Test
    public void testTxAllAnnotation(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        bookController.buyBook(1,1);
    }
}

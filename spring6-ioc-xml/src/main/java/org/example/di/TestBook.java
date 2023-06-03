package org.example.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-01-23:45
 */
public class TestBook {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_di.xml");
        Book book2 = context.getBean(Book.class);
        System.out.println(book2);
    }
}

package org.example.dimap;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-1:04
 */
public class TestStu {

    @Test
    public  void testStu() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_diref.xml");
        Student student = context.getBean("student", Student.class);
        student.run();
    }

}

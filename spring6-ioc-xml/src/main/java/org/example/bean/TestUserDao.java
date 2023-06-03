package org.example.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-01-23:07
 */
public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        //根据类型获取接口对应bean
        UserDao userDao = context.getBean(UserDao.class);
        userDao.run();

        /**
         * 1、若组件类实现了接口，可以根据接口类型获取bean
         * 2、若一个接口有多个实现类，这些实现类都配置了bean，不可以根据接口类型获取bean，因为bean不唯一
         * 3、其实，底层是用 对象 instanceof 指定类型来判断的
         */
//        UserDao userDao1 = context.getBean(UserDao.class);
//        userDao1.run();
    }
}

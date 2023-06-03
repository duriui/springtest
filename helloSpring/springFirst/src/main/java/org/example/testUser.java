package org.example;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-05-30-22:48
 */
public class testUser {

    private Logger logger = LoggerFactory.getLogger(testUser.class);

    @Test
    public void testUserObject(){
        //加载spring配置文件，对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //获取创建的对象
        User user = (User)context.getBean("user");
        System.out.println("1："+user);

        //使用对象调用方法进行测试
        System.out.print("2：");
        user.say();

        //手动写日志
        logger.info("执行调用成功");
    }

    //反射创建对象
    @Test
    public void testUserObject1() throws Exception {
        //获取类Class对象
        Class aClass = Class.forName("hzzp@huawei.com.User");

        //调用方法创建对象
        User user = (User)aClass.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}

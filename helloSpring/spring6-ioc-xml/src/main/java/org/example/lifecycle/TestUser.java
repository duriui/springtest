package org.example.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-12:37
 */
public class TestUser {


    /**
     * bean生命周期
     * 1、bean对象创建（调用无参数构造）
     * 2、给bean对象设置相关属性
     * 3、bean后置处理器（初始化之前）
     * 4、bean对象初始化（调用指定初始化方法）
     * 5、bean后置处理器（初始化之后）
     * 6、bean对象创建完成，可以使用了
     * 7、bean对象销毁（配置指定销毁的方法）
     * 8、Ioc容器关闭
     */
    @Test
    public void testUser(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_life.xml");
        User user = context.getBean(User.class);
        System.out.println("6、bean对象创建完成");
        System.out.println(user);
        context.close();
    }
}

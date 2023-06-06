package com.spring.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-2:05
 */
public class TestJdbc {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_jdbc.xml");
        DruidDataSource bean = context.getBean(DruidDataSource.class);
        System.out.println(bean.getUrl());
    }

    @Test
    public void testJdbc(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }
}

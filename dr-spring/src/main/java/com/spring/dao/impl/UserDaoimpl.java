package com.spring.dao.impl;

import com.spring.anno.Bean;
import com.spring.dao.UserDao;

@Bean
public class UserDaoimpl implements UserDao {
    public void add(){
        System.out.println("dao 执行了...");
    }
}

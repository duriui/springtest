package org.example.dao.impl;

import org.example.anno.Bean;
import org.example.dao.UserDao;

@Bean
public class UserDaoimpl implements UserDao {
    public void add(){
        System.out.println("dao 执行了...");
    }
}

package com.spring.service.impl;

import com.spring.anno.Bean;
import com.spring.anno.Di;
import com.spring.dao.UserDao;
import com.spring.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service执行.........");
        userDao.add();
    }
}

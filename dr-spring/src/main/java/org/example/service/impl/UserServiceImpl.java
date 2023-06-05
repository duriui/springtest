package org.example.service.impl;

import org.example.anno.Bean;
import org.example.anno.Di;
import org.example.dao.UserDao;
import org.example.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service执行.........");
    }
}

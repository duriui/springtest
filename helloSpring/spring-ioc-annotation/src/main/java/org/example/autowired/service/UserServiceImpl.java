package org.example.autowired.service;

import org.example.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-19:53
 */

@Service
public class UserServiceImpl implements UserService{

    //注入dao
    // 第一种方式：属性注入
    @Autowired  //根据类型找到对应对象，完成注入
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("sevice........");
        userDao.add();
    }
}

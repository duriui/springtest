package com.spring.auto.service;

import com.spring.auto.dao.UserDao;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-13:16
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDaoimpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("userService方法执行了");
        userDao.addUserDao();
//        UserDao userDaoimpl = new UserDaoimpl();
//        userDaoimpl.addUserDao();
    }
}

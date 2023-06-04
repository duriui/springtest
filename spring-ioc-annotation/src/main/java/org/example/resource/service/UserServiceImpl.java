package org.example.resource.service;

import jakarta.annotation.Resource;
import org.example.resource.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-19:53
 */

@Service(value = "myUserService")
public class UserServiceImpl implements UserService {

    @Resource(name = "MyUserDao")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("sevice........");
        userDao.add();
    }
}

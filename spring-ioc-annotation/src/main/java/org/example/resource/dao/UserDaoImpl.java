package org.example.resource.dao;

import org.springframework.stereotype.Repository;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-19:53
 */

@Repository(value = "MyUserDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("dao.......");
    }
}
package org.example.autowired.dao;

import org.springframework.stereotype.Repository;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-04-23:14
 */

@Repository
public class UserRedisDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("dao redis ........");
    }
}

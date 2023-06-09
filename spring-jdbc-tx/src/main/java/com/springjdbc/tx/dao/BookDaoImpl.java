package com.springjdbc.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements Bookdao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class , bookId);
//        System.out.println("价格是："+price) ;
        return price;
    }

    @Override
    public void updateBookStock(Integer bookId) {
        String sql = "update t_book set stock = stock -1 where book_id = ?";
        jdbcTemplate.update(sql,bookId);
    }

    @Override
    public void updateUserBalance(Integer userId,Integer price) {
        String sql = "update t_user set balance = balance - ? where user_id = ?";
        jdbcTemplate.update(sql,price,userId);
    }
}

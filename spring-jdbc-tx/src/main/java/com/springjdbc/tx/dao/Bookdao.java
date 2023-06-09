package com.springjdbc.tx.dao;

public interface Bookdao {
    public Integer getPriceByBookId(Integer bookId);

    public void updateBookStock(Integer bookId);

    public void updateUserBalance(Integer userId,Integer price);
}

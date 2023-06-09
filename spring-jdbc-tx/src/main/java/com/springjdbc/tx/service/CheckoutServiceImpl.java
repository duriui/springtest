package com.springjdbc.tx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService{


    @Autowired
    private BookService bookService;

    @Override
    @Transactional
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId:bookIds) {
            bookService.buyBook(userId,bookId);
        }
    }
}

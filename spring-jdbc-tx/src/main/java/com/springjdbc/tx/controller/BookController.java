package com.springjdbc.tx.controller;


import com.springjdbc.tx.service.BookService;
import com.springjdbc.tx.service.CheckoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);
    }

    @Autowired
    private CheckoutService checkoutService;
    @Test
    public void checkout(Integer[] bookIds,Integer userId){
            checkoutService.checkout(bookIds,userId);
    }
}

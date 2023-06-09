package com.springjdbc;

import com.springjdbc.tx.controller.BookController;
import com.springjdbc.tx.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class Main {

    @Autowired
    private BookController bookController;

//    @Test
//    public void testBuyBook(){
//        bookController.buyBook(1,2);
//    }

    @Test
    public void testBuyBook(){
        Integer[] bookIds = {1,2};
        bookController.checkout(bookIds,1);
    }
}
package org.example.di;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-01-23:33
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入有两种：set注入和构造器注入
 */
public class Book {

    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    public Book() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {

        //set方法注入
        Book book = new Book();
        book.setAuthor("DR");
        book.setName("JAVA");

        //构造器方法注入
        Book book1 = new Book("DDDRRR", "newJAVA");

    }
}

package com.springjdbc.tx.service;

import com.springjdbc.tx.dao.Bookdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(readOnly = true)
//@Transactional(timeout = 3)
//@Transactional(rollbackFor = ArithmeticException.class)    回滚
//@Transactional(rollbackForClassName = "java.lang.ArithmeticException.class")
//@Transactional(noRollbackFor = ArithmeticException.class)   不回滚
//@Transactional(noRollbackForClassName = "java.lang.ArithmeticException.class")
//@Transactional(isolation = Isolation.DEFAULT)   使用数据库默认的隔离级别
//@Transactional(isolation = Isolation.READ_UNCOMMITTED)   读未提交
//@Transactional(isolation = Isolation.READ_COMMITTED)  读已提交
//@Transactional(isolation = Isolation.READ_UNCOMMITTED)  可重复读
//@Transactional(isolation = Isolation.SERIALIZABLE)  串行化
//@Transactional(propagation = Propagation.REQUIRED)    支持当前事务，如果不存在就新建一个
//@Transactional(propagation = Propagation.REQUIRES_NEW)   不管当前有没有事务，都新建一个事务，这个新事务和当前事务没有嵌套关系，当前事务会被挂起
@Transactional(propagation = Propagation.REQUIRED)
/**
 *   事务属性：
 *   1、只读：设置只读，只能查询，不能修改添加删除
 *   2、超时：在设置超时时间，超过时间没有完成，抛出异常回滚
 *   3、回滚策略：设置哪些异常不回滚
 *   4、隔离级别：读问题
 *   5、传播行为：事务方法之间调用，事务如何使用
 */
public class BookServiceImpl implements BookService{

    @Autowired
    private Bookdao bookdao;
    @Override
    public void buyBook(Integer userId, Integer bookId) {
        // 获得图书Price
        Integer price = bookdao.getPriceByBookId(bookId);
        // 图书库存--
        bookdao.updateBookStock(bookId);
        // 用户余额--
        bookdao.updateUserBalance(userId,price);
    }
}

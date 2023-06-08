package com.springjdbc.jdbc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // 添加修改删除
    @Test
    public void testUpdate(){
        // 1、添加
        // 编写sql语句
        String sql = "insert into t_emp values(NULL,?,?,?)";
        //调用jdbcTemplate的方法，填入相关参数
        int rows = jdbcTemplate.update(sql, "黄豆", 20, "男");
        System.out.println(rows);
    }
}

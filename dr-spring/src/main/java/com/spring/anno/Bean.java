package com.spring.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)   //设置注解作用类型 在类上
@Retention(RetentionPolicy.RUNTIME)  //设置注解作用范围
public @interface Bean {
}

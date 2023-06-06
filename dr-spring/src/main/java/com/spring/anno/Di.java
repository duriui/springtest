package com.spring.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)   //设置注解作用类型 在属性上
@Retention(RetentionPolicy.RUNTIME)  //设置注解作用范围  运行时生效
public @interface Di {
}

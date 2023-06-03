package org.example.lifecycle;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-12:32
 */
public class User {
    private String name;

    public User(){
        System.out.println("1、bean对象创建，调用无参数构造创建对象");
    }

    //初始化方法
    public void initMethod(){
        System.out.println("4、bean对象初始化，调用指定的初始化方法");
    }

    //销毁的方法
    public void destoryMethod(){
        System.out.println("7、bean对象销毁，调用指定的销毁方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2、给bean对象设置属性值");
        this.name = name;
    }
}

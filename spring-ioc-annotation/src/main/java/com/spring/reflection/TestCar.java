package com.spring.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestCar {

    // 获取Class对象的各种方式
    @Test
    public void test01() throws Exception {
        //1、类名.class
        Class clazz1 = Car.class;

        //2、对象.getClass
        Class clazz2 = new Car().getClass();

        //3、Class.forName("全路径")
        Class clazz3 = Class.forName("com.spring.reflection.Car");

        //实例化
        Car car = (Car)clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    // 获取所有的构造方法
    @Test
    public void test02() throws Exception {
        Class clazz = Car.class;
        Constructor[] constructors = clazz.getConstructors();  //获得所有public的构造方法
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors(); //获得所有构造方法包括public private
        for (Constructor c:constructors) {
            System.out.println(c.getName()+"   "+c.getParameterCount());
        }

        // 指定有参数构造创建对象

        // 1、构造public
//        Constructor c1 = clazz.getConstructor(String.class, Integer.class, String.class);
//        Car car1 = (Car) c1.newInstance("BMW", 2, "Red");
//        System.out.println(car1);

        // 2、构造private
        Constructor c2 = clazz.getDeclaredConstructor(String.class, Integer.class, String.class);
        c2.setAccessible(true);   //设置为true，表示可以访问私有构造方法
        Car car2 = (Car) c2.newInstance("大众", 5, "Black");
        System.out.println(car2);
    }

    // 3、获取属性
    @Test
    public void test03() throws Exception{
        Class clazz = Car.class;
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();

        // 获取所有public属性
        Field[] fields = clazz.getFields();

        // 获取所有属性，包括private
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f:declaredFields) {
            if(f.getName().equals("name")){
                f.setAccessible(true);
                f.set(car,"五菱宏光");
            }
            System.out.println(car);
            System.out.println(f.getName()+"  "+f.getType());
        }
    }

    // 4、获取方法
    @Test
    public void test04() throws Exception{
        Car car = new Car("奔驰", 10, "黑色");
        Class clazz = car.getClass();

        // 获取所有public方法
//        Method[] methods = clazz.getMethods();
//        for (Method m:methods) {
//            // 执行 toString()方法
//            if(m.getName().equals("toString")){
//                String s = (String) m.invoke(car);
//                System.out.println("toString方法执行了"+s);
//            }
//            //System.out.println(m.getName());
//        }
        // 获取所有方法，包括private
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m1:declaredMethods) {
            if(m1.getName().equals("run")){
                m1.setAccessible(true);
                m1.invoke(car);

            }
            //System.out.println(m1.getName());
        }
    }
}

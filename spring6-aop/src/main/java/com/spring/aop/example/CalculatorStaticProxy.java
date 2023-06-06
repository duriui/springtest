package com.spring.aop.example;


/**
 * 静态代理实现了解耦，但是不灵活，进一步需求——>将日志功能集中到一个代理类中，将来有任何日志请求，都通过这个代理类来实现--->动态代理
 */

public class CalculatorStaticProxy implements Calculator{

    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int x, int y) {
        // 输入日志
        System.out.println("【日志】add方法开始了，参数是："+x+"，"+y);

        // 调用目标对象的方法实现核心业务
        int addResult = calculator.add(x,y);

        System.out.println("【日志】add方法结束了，结果是："+addResult);
        return 0;
    }

    @Override
    public int sub(int x, int y) {
        // 输入日志
        System.out.println("【日志】sub方法开始了，参数是："+x+"，"+y);

        // 调用目标对象的方法实现核心业务
        int subResult = calculator.sub(x,y);

        System.out.println("【日志】sub方法结束了，结果是："+subResult);
        return 0;
    }

    @Override
    public int mul(int x, int y) {
        // 输入日志
        System.out.println("【日志】mul方法开始了，参数是："+x+"，"+y);

        // 调用目标对象的方法实现核心业务
        int mulResult = calculator.mul(x,y);

        System.out.println("【日志】mul方法结束了，结果是："+mulResult);
        return 0;
    }

    @Override
    public int div(int x, int y) {
        // 输入日志
        System.out.println("【日志】div方法开始了，参数是："+x+"，"+y);

        // 调用目标对象的方法实现核心业务
        int divResult = calculator.div(x,y);

        System.out.println("【日志】add方法结束了，结果是："+divResult);
        return 0;
    }
}

package com.spring.aop.example;

public class CalculatorLogImpl implements Calculator{
    @Override
    public int add(int x, int y) {
        System.out.println("方法要开始了。。。。。。");
        int res = x+y;
        System.out.println("方法内部 result = "+res);
        System.out.println("方法要结束了。。。。。。");
        return res;
    }

    @Override
    public int sub(int x, int y) {
        System.out.println("方法要开始了。。。。。。");
        int res = x-y;
        System.out.println("方法内部 result = "+res);
        System.out.println("方法要结束了。。。。。。");
        return res;
    }

    @Override
    public int mul(int x, int y) {
        System.out.println("方法要开始了。。。。。。");
        int res = x*y;
        System.out.println("方法内部 result = "+res);
        System.out.println("方法要结束了。。。。。。");
        return res;
    }

    @Override
    public int div(int x, int y) {
        System.out.println("方法要开始了。。。。。。");
        int res = x/y;
        System.out.println("方法内部 result = "+res);
        System.out.println("方法要结束了。。。。。。");
        return res;
    }
}

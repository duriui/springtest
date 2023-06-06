package com.spring.aop.example;


//基本实现类
public class CalculatorImpl implements Calculator{

    @Override
    public int add(int x, int y) {
        int res = x+y;
        System.out.println("方法内部 result = "+res);
        return res;
    }

    @Override
    public int sub(int x, int y) {
        int res = x-y;
        System.out.println("方法内部 result = "+res);
        return res;
    }

    @Override
    public int mul(int x, int y) {
        int res = x*y;
        System.out.println("方法内部 result = "+res);
        return res;
    }

    @Override
    public int div(int x, int y) {
        int res = x/y;
        System.out.println("方法内部 result = "+res);
        return res;
    }
}

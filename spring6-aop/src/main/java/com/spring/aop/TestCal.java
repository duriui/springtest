package com.spring.aop;

import com.spring.aop.example.Calculator;
import com.spring.aop.example.CalculatorImpl;
import com.spring.aop.example.ProxyFactory;

public class TestCal {
    public static void main(String[] args) {

        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);
        proxy.mul(2,3);
    }
}

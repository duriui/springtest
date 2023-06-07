package com.spring.xmlaop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 切面类
@Component  //ioc容器
public class LogAspect {

    // 前置通知
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->前置通知，方法名称："+methodName+"，参数："+ Arrays.toString(args));
    }

    // 后置通知
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->后置通知，方法名称："+methodName+"，参数："+ Arrays.toString(args));
    }

    // 返回通知
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->返回通知，方法名称："+methodName+"，参数："+ Arrays.toString(args));
        System.out.println("目标方法返回的结果："+result);
    }

    // 异常通知
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->异常通知，方法名称："+methodName+"，参数："+ Arrays.toString(args)+"，异常信息："+ex);

    }

    // 环绕通知
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try{
            System.out.println("环绕通知===目标方法执行之前");
            result = joinPoint.proceed();
            System.out.println("环绕通知===目标方法返回值之后");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕通知===目标方法执行出现异常");
        }finally {
            System.out.println("环绕通知===目标方法执行完毕");
        }
        return result;
        //System.out.println("Logger--->环绕通知，方法名称："+methodName+"，参数："+ Arrays.toString(args));
    }


    // 重用切面表达式
    @Pointcut(value = "execution(* com.spring.xmlaop.CalculatorImpl.*(..))")
    public void pointCut(){

    }


}

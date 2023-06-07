package com.spring.annoaop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 切面类
@Aspect    // 切面类
@Component  //ioc容器
public class LogAspect {


    /** 设置切入点和通知类型
     * 通知类型：
     * 1、前置通知  @Before()
     * 2、返回通知  @AfterReturning
     * 3、异常通知  @AfterThrowing
     * 4、后置通知  @After()
     * 5、环绕通知  @Around()
     *
     * 配置切入点表达式：execution(方法访问修饰符(可以省略) 增强方法的返回类型(*代表任意类型) 增强方法所在类的全路径.方法(*代表任意方法)(参数列表(..代表任意类型的参数))
     *
     * @annotation 的作用是匹配标注了特定注解的方法，语法如下：
     *      @annotation(annotation-type)
     * annotation-type是要匹配的注解类型
     * 如：
     *
     * 切面优先级
     * 相同目标方法同时存在多个切面时，切面优先级控制切面的内外嵌套顺序
     * 优先级高的切面：外面
     * 优先级低的切面：里面
     *
     * 使用@Order注解可以控制切面的优先级
     * @Order(较小的数)：优先级高
     * @Order(较大的数)：优先级低
     */

    @Before(value = "pointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->前置通知，方法名称："+methodName+"，参数："+ Arrays.toString(args));
    }

    // 若是不同切面，需要提供全路径
    // @After(value = "com.spring.annoaop.LogAspect.pointCut()")
    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->后置通知，方法名称："+methodName+"，参数："+ Arrays.toString(args));
    }

    // 返回通知可以得到目标方法的返回值
    @AfterReturning(value = "execution(* com.spring.annoaop.CalculatorImpl.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->返回通知，方法名称："+methodName+"，参数："+ Arrays.toString(args));
        System.out.println("目标方法返回的结果："+result);
    }

    // 可以得到目标方法的异常信息，当目标方法执行出现异常的时候，这个通知执行
    @AfterThrowing(value = "execution(* com.spring.annoaop.CalculatorImpl.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->异常通知，方法名称："+methodName+"，参数："+ Arrays.toString(args)+"，异常信息："+ex);

    }

    @Around(value = "execution(* com.spring.annoaop.CalculatorImpl.*(..))")
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
    @Pointcut(value = "execution(* com.spring.annoaop.CalculatorImpl.*(..))")
    public void pointCut(){

    }


}

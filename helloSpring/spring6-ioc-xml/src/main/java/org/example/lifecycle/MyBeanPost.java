package org.example.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-12:59
 */
public class MyBeanPost implements BeanPostProcessor {

    /**
     * bean的后置处理器会在生命周期的初始化前后添加额外的操作，需要实现BeanPostProcessor接口，且配置
     * 到IOC容器中去，需要注意的是，bean后置处理器不仅仅针对某一个bean生效，而是对IOC容器中所有的bean都会执行
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3、bean后置处理器，初始化之前执行");
        System.out.println(beanName+"::"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5、bean后置处理器，初始化之后执行");
        System.out.println(beanName+"::"+bean);
        return bean;
    }
}

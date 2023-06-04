package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-05-0:07
 */

@Configuration   //配置类，有这个类就不需要spring的xml配置文件了
@ComponentScan("org.example") // 开启组件臊面
public class SpringConfig {
}

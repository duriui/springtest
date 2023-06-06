package com.spring.spring6;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-19:33
 */

/**
 * @Component 用于描述Spring的bean，是个泛华的概念，仅仅表示容器中的一个组件(Bean)，并且可以作用在应用的任何层次
 * @Repository 用于将数据访问层（Dao层）的类标识为Spring中的Bean，功能与@Component相同
 * @Service 用于将业务层（Service层）的类标识为Spring中的Bean，功能与@Component相同
 * @Controller 用于将控制层（Controller层）的类标识为Spring中的Bean，功能与@Component相同
 */

@Component(value = "user") //<bean id="user" class="...">   属性值不写，默认是类名首字母小写
//@Repository
//@Service
//@Controller
public class User {

}

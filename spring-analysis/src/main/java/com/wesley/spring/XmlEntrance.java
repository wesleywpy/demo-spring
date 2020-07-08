package com.wesley.spring;

import com.wesley.spring.entity.User;
import com.wesley.spring.support.UserFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/07/08
 */
public class XmlEntrance {
    public static void main(String[] args) {
        String path = "spring-config.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        //得到无参构造函数创建的对象:
        User user1a = (User) applicationContext.getBean("user1");
        User user1b = (User) applicationContext.getBean("user1");

        //得到静态工厂创建的对象：
        User user2a = (User) applicationContext.getBean("user2");
        User user2c = (User) applicationContext.getBean("user2");

        //得到实例工厂创建的对象：
        User user3a = (User) applicationContext.getBean("user3");
        User user3b = (User) applicationContext.getBean("user3");

        //得到beanFactory创建的对象：
        UserFactoryBean userFactoryBean4a = (UserFactoryBean) applicationContext.getBean("&userFactoryBean");
        User user4b = (User) applicationContext.getBean("userFactoryBean");

        System.out.println("无参构造函数创建的对象:" + user1a);
        System.out.println("无参构造函数创建的对象:" + user1b);
        System.out.println("静态工厂创建的对象：" + user2a);
        System.out.println("静态工厂创建的对象：" + user2c);
        System.out.println("实例工厂创建的对象：" + user3a);
        System.out.println("实例工厂创建的对象：" + user3b);
        System.out.println("factorybean对象：" + userFactoryBean4a);
        System.out.println("factorybean创建的对象：" + user4b);
    }
}

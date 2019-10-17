package com.wesley.springboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * <p>
 * HelloWorld初始化器
 * </p>
 *
 * @author Created by Yani on 2019/10/17
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {

    @Override
    public void initialize(C applicationContext) {
        System.out.println("HelloWorldApplicationContextInitializer --> Id : " + applicationContext.getId());
    }
}

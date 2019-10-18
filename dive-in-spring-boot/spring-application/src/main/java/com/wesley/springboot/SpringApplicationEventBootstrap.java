package com.wesley.springboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * Spring 应用事件 引导类
 * </p>
 *
 * @author Created by Yani on 2019/10/18
 */
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册 应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听到的事件 --> " + event);
        });

        context.refresh();

        // 发送事件
        context.publishEvent("HelloWorld");
        context.publishEvent(new ApplicationEvent("小马哥") {

        });

        context.close();
    }
}

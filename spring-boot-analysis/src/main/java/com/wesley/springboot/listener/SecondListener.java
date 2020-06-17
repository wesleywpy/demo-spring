package com.wesley.springboot.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * <p>
 *  应用监听器
 * </p>
 *
 * @author Created by Yani on 2020/04/15
 */
@Order(2)
public class SecondListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println(" -----> Run SecondListener ..... 监听事件: ApplicationStartedEvent");
    }

}

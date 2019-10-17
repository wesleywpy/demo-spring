package com.wesley.springboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * <p>
 * HelloWorld {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 * </p>
 *
 * @author Created by Yani on 2019/10/17
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("HelloWorldApplicationListener --> id : " + event.getApplicationContext().getId()
                                   + " , timestamp : " + event.getTimestamp());
    }

}

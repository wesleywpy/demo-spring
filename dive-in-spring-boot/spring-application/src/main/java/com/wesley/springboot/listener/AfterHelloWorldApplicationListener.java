package com.wesley.springboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * <p>
 * HelloWorld {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 * </p>
 *
 * @author Created by Yani on 2019/10/17
 */
public class AfterHelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent>, Ordered {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("After HelloWorldApplicationListener --> id: " + event.getApplicationContext().getId()
                                   + " , timestamp : " + event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}

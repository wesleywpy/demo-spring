package com.wesley.springboot.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * <p>
 *  可同时对多个事件进行监听
 * </p>
 *
 * @author Created by Yani on 2020/04/16
 */
public class FourthListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        // 监听的事件类型
        return ApplicationStartedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(" -----> Run FourthListener ..... 监听事件: "+ event.toString());
    }

    @Override
    public int getOrder() {
        return 4;
    }
}

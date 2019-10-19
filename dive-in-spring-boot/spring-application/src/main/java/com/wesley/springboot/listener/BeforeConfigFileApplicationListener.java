package com.wesley.springboot.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Before {@link ConfigFileApplicationListener} s实现
 * @author Created by Wesley on 2019/10/19
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 监听 ApplicationEnvironmentPreparedEvent 事件
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent enviromentEvent = (ApplicationEnvironmentPreparedEvent)event;
            ConfigurableEnvironment environment = enviromentEvent.getEnvironment();
            String name = environment.getProperty("name");
            System.out.println("environment name --> "+ name);
        }

        if (event instanceof ApplicationPreparedEvent) {

        }
    }

    @Override
    public int getOrder() {
        // 在 ConfigFileApplicationListener 之前执行
        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
    }
}

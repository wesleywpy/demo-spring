package com.wesley.springboot.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  应用上下文初始化器
 * </p>
 *
 * @author Created by Yani on 2020/04/03
 */
@Order(1)
public class FirstInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        Map<String, Object> map = new HashMap<>();
        map.put("FirstInitializer.key", "FirstInitializer.val");
        MapPropertySource propertySource = new MapPropertySource("FirstInitializer", map);
        environment.getPropertySources()
                   .addLast(propertySource);

        System.out.println(" -----> Run FirstInitializer .....");
    }
}

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
@Order(3)
public class ThirdInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        Map<String, Object> map = new HashMap<>();
        map.put("ThirdInitializer.key", "ThirdInitializer.val");
        MapPropertySource propertySource = new MapPropertySource("ThirdInitializer", map);
        environment.getPropertySources()
                   .addLast(propertySource);

        System.out.println(" -----> Run ThirdInitializer .....");
    }
}

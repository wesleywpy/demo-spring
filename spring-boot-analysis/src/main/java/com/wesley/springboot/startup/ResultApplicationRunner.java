package com.wesley.springboot.startup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/05/13
 */
@Component
@Order(5)
public class ResultApplicationRunner implements ApplicationRunner, EnvironmentAware {
    private Environment environment;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String addr = environment.getProperty("wesley.academy.addr");
        System.out.println(" -----> "+ addr);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}

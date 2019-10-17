package com.wesley.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/17
 */
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
//        SpringApplication.run(ApplicationConfiguration.class, args);

        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(ApplicationConfiguration.class)
                .run(args);

        context.close();
    }

    /**
     * {@link SpringApplication} 引导类
     */
    @SpringBootApplication
    public static class ApplicationConfiguration{

    }
}

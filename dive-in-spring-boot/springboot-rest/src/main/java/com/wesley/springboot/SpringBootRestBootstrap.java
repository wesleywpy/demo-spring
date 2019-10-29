package com.wesley.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/25
 */
@SpringBootApplication(scanBasePackages = {"com.wesley.springboot.controller", "com.wesley.springboot.config"})
public class SpringBootRestBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class, args);
    }

}

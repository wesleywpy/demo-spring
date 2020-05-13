package com.wesley.springboot.startup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/05/13
 */
@Component
public class FirstApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(" \u001B[32m >>> startup first ApplicationRunner <<<");
    }
}

package com.wesley.springboot.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/05/13
 */
@Component
public class FirstCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(" \u001B[32m >>> startup first CommandLineRunner <<<");
    }
}

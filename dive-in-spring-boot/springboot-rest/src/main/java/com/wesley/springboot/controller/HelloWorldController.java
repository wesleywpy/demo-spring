package com.wesley.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/25
 */
@RestController
public class HelloWorldController {

    @GetMapping(value = "/hello")
    public String helloWorld(@RequestParam(required = false, defaultValue = "haha") String msg) {
        return "Hello, World ! " + msg;
    }
}

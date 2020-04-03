package com.wesley.springboot.controller;

import com.wesley.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/04/03
 */
@RestController
public class DemoController {

    @Autowired
    TestService testService;

    @GetMapping("/test/initializer")
    public String testInitializer() {
        return testService.testInitializer();
    }
}

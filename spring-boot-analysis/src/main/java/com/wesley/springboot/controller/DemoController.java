package com.wesley.springboot.controller;

import com.wesley.growth.spring.StarterService;
import com.wesley.springboot.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    TestService testService;

    @Autowired
    StarterService starterService;

    @GetMapping("/test/initializer")
    public String testInitializer() {
        return testService.testInitializer();
    }

    @GetMapping("/test/starter")
    public String[] testStarter() {
        return starterService.split(",");
    }

    @GetMapping("/test/log")
    public String testLog() {
        log.info(" ------> msg: {}", "this is a info msg");
        log.warn(" ------> msg: {}", "this is a warn msg");
        return "Success";
    }

}

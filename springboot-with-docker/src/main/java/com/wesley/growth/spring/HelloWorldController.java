package com.wesley.growth.spring;

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

    @GetMapping(value = "/hello/k8s")
    public String helloK8s() {
        return "Hello, Kubernetes ! ";
    }

    @GetMapping(value = "/hello/k8s/pod")
    public String helloK8sPod() {
        return "Hello, Kubernetes Pod! ";
    }

    @GetMapping(value = "/words")
    public String words(@RequestParam(required = false, defaultValue = "Java") String msg) {
        return "Words: "+ msg;
    }

}

package com.wesley.springboot.controller;

import com.wesley.springboot.domain.User;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.Properties;
import java.util.Random;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/28
 */
@RestController
public class UserController {

    /**
     *
     */
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = "application/json;charset=GBK")
    public User add(@RequestBody User user) {
        int id = new Random().nextInt(100);
        user.setId(id);
        return user;
    }

    /**
     * 自定义 {@link HttpMessageConverter} 测试
     */
    @PostMapping(value = "/users/properties", consumes = "text/properties;charset=UTF-8")
    public Properties addProperties(@RequestBody Properties properties) {
        properties.setProperty("sign", "wesley");
        return properties;
    }

    /**
     * {@link Properties} 类型 {@link HandlerMethodArgumentResolver} 测试
     */
    @PostMapping(value = "/users/props")
    public Properties addPros(Properties properties) {
        properties.setProperty("sign", "wesley");
        return properties;
    }

}

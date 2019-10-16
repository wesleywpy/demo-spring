package com.wesley.springboot.conf;

import com.wesley.springboot.annotation.EnableHelloWorld;
import com.wesley.springboot.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * HellWorld 自动装配
 * </p>
 *
 * @author Created by Yani on 2019/10/16
 */
@Configuration // Spring 模式注解
@EnableHelloWorld // @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "yani") // 条件装配
public class HelloWorldAutoConfiguration {
}

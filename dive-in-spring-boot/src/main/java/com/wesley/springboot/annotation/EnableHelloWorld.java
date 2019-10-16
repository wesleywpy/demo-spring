package com.wesley.springboot.annotation;

import com.wesley.springboot.conf.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <p>
 *  激活 HelloWorld 模块
 * </p>
 *
 * @author Created by Yani on 2019/10/16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
// 基于注解
//@Import(HelloWorldConfiguration.class)
// 基于接口
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}

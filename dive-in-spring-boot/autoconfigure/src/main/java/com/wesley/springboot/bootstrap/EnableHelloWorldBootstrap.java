package com.wesley.springboot.bootstrap;

import com.wesley.springboot.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <p>
 * {@link EnableHelloWorld} 引导类
 * </p>
 *
 * @author Created by Yani on 2019/10/16
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorldBean = context.getBean("helloWorld", String.class);
        System.out.println(helloWorldBean);

        context.close();
    }
}

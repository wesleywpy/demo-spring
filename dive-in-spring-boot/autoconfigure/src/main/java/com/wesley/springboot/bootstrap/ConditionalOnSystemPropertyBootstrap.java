package com.wesley.springboot.bootstrap;

import com.wesley.springboot.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * 系统属性条件引导类
 * </p>
 *
 * @author Created by Yani on 2019/10/16
 */
public class ConditionalOnSystemPropertyBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "yani")
    public String helloWorld() {
        return "Hello World, ConditionalProperty";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorldBean = context.getBean("helloWorld", String.class);
        System.out.println(helloWorldBean);

        context.close();
    }
}

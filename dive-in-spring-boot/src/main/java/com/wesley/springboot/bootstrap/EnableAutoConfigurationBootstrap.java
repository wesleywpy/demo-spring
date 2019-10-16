package com.wesley.springboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <p>
 * {@link EnableAutoConfiguration} 引导类
 * </p>
 *
 * @author Created by Yani on 2019/10/16
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorldBean = context.getBean("helloWorld", String.class);
        System.out.println(helloWorldBean);

        context.close();
    }
}

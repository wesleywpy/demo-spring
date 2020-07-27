package com.wesley.spring;

import com.wesley.spring.controller.WelcomeController;
import com.wesley.spring.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/07/09
 */
@Configuration
@ComponentScan("com.wesley.spring")
public class AnnoEntrance {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnoEntrance.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            System.out.println(beanDefinitionName);
        }

        WelcomeController welcomeController = (WelcomeController) applicationContext.getBean("welcomeController");
        welcomeController.handleRequest();
        User user = (User)applicationContext.getBean("user05");
        System.out.println(" ------> "+ user);
    }
}

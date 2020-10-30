package com.wesley.spring;

import com.wesley.spring.entity.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Entrance
 *
 * @author WangPanYong
 * @since 2020/10/30 14:19
 */
public class Entrance {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnoEntrance.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            System.out.println(beanDefinitionName);
        }

        Company company = (Company) applicationContext.getBean("company");
    }
}

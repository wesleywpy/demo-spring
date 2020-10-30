package com.wesley.spring.controller;

import com.wesley.spring.service.DemoService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController implements ApplicationContextAware, BeanNameAware {
	private String myName;
	private ApplicationContext myContainer;

	private final DemoService demoService;

    public WelcomeController(DemoService demoService) {
        this.demoService = demoService;
    }

    public void handleRequest(){
		System.out.println("\r\n -----> 我是谁：" + myName);
		String[] beanDefinitionNames = myContainer.getBeanDefinitionNames();
		for(String beanDefinitionName : beanDefinitionNames) {
			System.out.println("召唤容器神兽，通过神兽获得：" + beanDefinitionName);
		}
	}

	@Override
	public void setBeanName(String name) {
		this.myName = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.myContainer = applicationContext;
	}
}

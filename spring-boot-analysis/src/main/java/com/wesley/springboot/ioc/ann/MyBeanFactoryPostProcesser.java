package com.wesley.springboot.ioc.ann;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Wesley on 2020/04/19
 */
@Component
public class MyBeanFactoryPostProcesser implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(" -----> 自定义BeanFactoryPostProcesser ...");
        BeanDefinition philosopher = beanFactory.getBeanDefinition("philosopher");
        MutablePropertyValues propertyValues = philosopher.getPropertyValues();
        propertyValues.addPropertyValue("name", "Socrares");
    }
}

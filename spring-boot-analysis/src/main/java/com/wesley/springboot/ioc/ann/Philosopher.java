package com.wesley.springboot.ioc.ann;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Wesley on 2020/04/19
 */
@Component
public class Philosopher implements BeanPostProcessor , InitializingBean {

    private static final Log logger = LogFactory.getLog(Philosopher.class);

    private String name = "non";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 每个Bean都会执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        logger.info(" ------> postProcessBeforeInitialization : " + beanName);
//        if (beanName.equals("philosopher")) {
//            logger.info(" \t ------> Philosopher BeanPostProcessor Before");
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        logger.info(" ------> postProcessAfterInitialization : " + beanName);
//        if (beanName.equals("philosopher")) {
//            logger.info(" \t ------> Philosopher BeanPostProcessor After");
//        }
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info(" ------> Bean设置参数之后的操作 ...");
    }
}

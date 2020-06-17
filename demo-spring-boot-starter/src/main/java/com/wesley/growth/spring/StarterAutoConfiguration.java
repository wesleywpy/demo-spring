package com.wesley.growth.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 自动配置类
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/07/24
 */
@Configuration
@EnableConfigurationProperties(StarterServiceProperties.class)
@ConditionalOnClass(StarterService.class)
@ConditionalOnProperty(value = "wesley.starter.enabled", havingValue = "true", matchIfMissing = false)
public class StarterAutoConfiguration {

    /**
     * 注解@ConditionalOnClass，当classpath下发现该类的情况下进行自动配置
     * 注解@ConditionalOnMissingBean，当Spring Context中不存在该Bean时, 才进行注册
     * 注解@ConditionalOnBean:当容器中有指定的Bean的条件下
     * 注解@ConditionalOnClass：当类路径下有指定的类的条件下
     * 注解@ConditionalOnExpression:基于SpEL表达式作为判断条件
     * 注解@ConditionalOnJava:基于JVM版本作为判断条件
     * 注解@ConditionalOnJndi:在JNDI存在的条件下查找指定的位置
     * 注解@ConditionalOnMissingBean:当容器中没有指定Bean的情况下
     * 注解@ConditionalOnMissingClass:当类路径下没有指定的类的条件下
     * 注解@ConditionalOnNotWebApplication:当前项目不是Web项目的条件下
     * 注解@ConditionalOnProperty:指定的属性是否有指定的值
     * 注解@ConditionalOnResource:类路径下是否有指定的资源
     */

    @Autowired
    StarterServiceProperties properties;

    /**
     * 当配置文件中 demo.service.enabled=true 时,才注册
     */
    @Bean
    @ConditionalOnMissingBean
    public StarterService starterService() {
        return new StarterService(properties.getConfig());
    }


}

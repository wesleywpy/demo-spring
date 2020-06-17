package com.wesley.springboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * <p>
 *  自定义 条件注解 解析类
 * </p>
 *
 * @author Created by Yani on 2020/06/17
 */
public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes("com.wesley.springboot.condition.MyConditionAnnotation");
        String[] values = (String[]) annotationAttributes.get("value");
        Environment environment = context.getEnvironment();

        // 加载Bean具体的业务逻辑
        for (String value : values) {
            if (StringUtils.isEmpty(environment.getProperty(value))) {
                return false;
            }
        }

        return true;
    }

}

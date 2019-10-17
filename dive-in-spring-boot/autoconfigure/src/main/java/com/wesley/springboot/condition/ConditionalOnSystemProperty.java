package com.wesley.springboot.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * <p>
 * Java 系统属性 条件判断
 * </p>
 *
 * @author Created by Yani on 2019/10/16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional({OnSystemPropertyCondition.class})
public @interface ConditionalOnSystemProperty {
    /**
     * 系统属性名称
     */
    String name() default "";

    /**
     * 系统属性值
     */
    String value() default "";
}

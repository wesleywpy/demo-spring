package com.wesley.springboot.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * <p>
 *      自定义 条件注解
 * </p>
 *
 * @author Created by Yani on 2020/06/17
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(MyCondition.class)
public @interface MyConditionAnnotation {

    String[] value() default {};
}

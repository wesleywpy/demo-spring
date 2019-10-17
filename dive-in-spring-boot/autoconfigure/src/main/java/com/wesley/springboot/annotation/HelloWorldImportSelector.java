package com.wesley.springboot.annotation;

import com.wesley.springboot.conf.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p>
 *  HelloWorld {@link ImportSelector} 实现
 * </p>
 *
 * @author Created by Yani on 2019/10/16
 */
public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }

}

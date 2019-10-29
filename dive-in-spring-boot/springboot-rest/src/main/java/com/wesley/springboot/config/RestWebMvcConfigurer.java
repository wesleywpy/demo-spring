package com.wesley.springboot.config;

import com.wesley.springboot.http.converter.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/29
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 添加到第一个位置
        converters.add(0, new PropertiesHttpMessageConverter());
    }
}

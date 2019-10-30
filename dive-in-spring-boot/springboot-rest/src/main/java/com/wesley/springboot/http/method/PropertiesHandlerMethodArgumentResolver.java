package com.wesley.springboot.http.method;

import com.wesley.springboot.http.converter.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

/**
 * <p>
 *  {@link Properties 类型} {@link HandlerMethodArgumentResolver}
 * </p>
 *
 * @author Created by Yani on 2019/10/30
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();

        HttpServletRequest nativeRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(nativeRequest);
        return converter.read(null, null, inputMessage);
    }

}

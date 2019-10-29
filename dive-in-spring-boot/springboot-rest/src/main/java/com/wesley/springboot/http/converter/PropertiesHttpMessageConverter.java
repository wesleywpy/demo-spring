package com.wesley.springboot.http.converter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Properties;

/**
 * <p>
 * {@link Properties} {@link HttpMessageConverter} 实现
 * </p>
 *
 * @author Created by Yani on 2019/10/29
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

    public PropertiesHttpMessageConverter() {
        // 支持的媒体类型
        super(new MediaType("text", "properties"));
    }

    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // Properties对象 转换为 字符串
        HttpHeaders headers = outputMessage.getHeaders();
        MediaType contentType = headers.getContentType();

        Charset charset = Charset.defaultCharset();
        if (Objects.nonNull(contentType)) {
            Charset contentTypeCharset = contentType.getCharset();
            charset = contentTypeCharset != null ? contentTypeCharset : charset;
        }

        // 字符输出流
        Writer writer = new OutputStreamWriter(outputMessage.getBody(), charset);
        // Properties 写入到字符输出流
        properties.store(writer,"From PropertiesHttpMessageConverter");
    }

    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        // 请求体字符流 -> Properties
        HttpHeaders headers = inputMessage.getHeaders();
        MediaType contentType = headers.getContentType();

        Charset charset = Charset.defaultCharset();
        if (Objects.nonNull(contentType)) {
            Charset contentTypeCharset = contentType.getCharset();
            charset = contentTypeCharset != null ? contentTypeCharset : charset;
        }

        // 加载字符流成为 Properties 对象
        InputStreamReader reader = new InputStreamReader(inputMessage.getBody(), charset);
        Properties properties = new Properties();
        properties.load(reader);
        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, inputMessage);
    }

}

package com.wesley.growth.spring;

import org.springframework.util.StringUtils;

/**
 * <p>
 * starter 实现的业务逻辑
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/07/24
 */
public class StarterService {
    /**
     * 配置文件的配置参数
     */
    private String config;

    public StarterService(String config) {
        this.config = config;
    }

    /**
     * 业务逻辑方法
     * @param separator 分隔符
     */
    public String[] split(String separator) {
        return StringUtils.split(config, separator);
    }
}

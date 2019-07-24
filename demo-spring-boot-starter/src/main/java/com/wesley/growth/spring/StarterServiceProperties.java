package com.wesley.growth.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * 配置文件读取类
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/07/24
 */
@ConfigurationProperties("demo.service")
public class StarterServiceProperties {
    private String config;

    private boolean enabled = false;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

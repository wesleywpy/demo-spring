package com.wesley.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * <p>
 *  ServletComponentScan注解: 扫描自定义Servlet
 * </p>
 * @author Created by Wesley on 2019/10/07
 */
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.wesley.springboot.web.servlet"})
public class DiveInApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiveInApplication.class, args);
    }

}

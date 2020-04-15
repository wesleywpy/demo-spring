package com.wesley.springboot;

import com.wesley.springboot.initializer.SecondInitializer;
import com.wesley.springboot.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/04/03
 */
@SpringBootApplication
public class AnalysisApplication {

    public static void main(String[] args) {
//        SpringApplication.run(AnalysisApplication.class, args);
        SpringApplication springApplication = new SpringApplication(AnalysisApplication.class);
//        // 注册 应用上下文初始化器 方式2
//        springApplication.addInitializers(new SecondInitializer());

        // 注册 应用监听器 方式2
        springApplication.addListeners(new SecondListener());
        springApplication.run(args);
    }

}

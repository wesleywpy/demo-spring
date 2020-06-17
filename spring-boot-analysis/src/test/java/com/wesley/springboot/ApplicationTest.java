package com.wesley.springboot;

import com.wesley.springboot.condition.Stoics;
import com.wesley.springboot.ioc.ann.Monkey;
import com.wesley.springboot.ioc.ann.Philosopher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Wesley on 2020/04/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest implements ApplicationContextAware {

    @Autowired
    Monkey monkey;

    @Autowired
    Philosopher philosopher;

    private ApplicationContext applicationContext;

    @Test
    public void testName() {
        System.out.println(philosopher.getName());
        Thread hookThead = new Thread(() -> {
            System.out.println(" 关闭 Jvm ... 执行逻辑 ");
        });
        Runtime.getRuntime().addShutdownHook(hookThead);
    }

    @Test
    public void testCondition() {
        Stoics bean = this.applicationContext.getBean(Stoics.class);
        System.out.println(bean);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

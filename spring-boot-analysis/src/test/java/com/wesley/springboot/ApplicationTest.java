package com.wesley.springboot;

import com.wesley.springboot.ioc.ann.Monkey;
import com.wesley.springboot.ioc.ann.Philosopher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class ApplicationTest {

    @Autowired
    Monkey monkey;

    @Autowired
    Philosopher philosopher;

    @Test
    public void testName() {
        System.out.println(philosopher.getName());
    }

}

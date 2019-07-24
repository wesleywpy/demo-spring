package com.wesley.growth.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/07/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTest {

    @Autowired
    StarterService starterService;

    @Test
    public void testStarter() {
        String[] strings = starterService.split(" ");
        Arrays.stream(strings).forEach(System.out::println);
    }
}
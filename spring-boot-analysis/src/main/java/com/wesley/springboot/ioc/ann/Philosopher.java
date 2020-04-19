package com.wesley.springboot.ioc.ann;

import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Wesley on 2020/04/19
 */
@Component
public class Philosopher {
    private String name = "non";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.wesley.springboot.ioc.ann;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Wesley on 2020/05/02
 */
@Component
public class Worker {

    private final Monkey monkey;

    public Worker(Monkey monkey) {
        this.monkey = monkey;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

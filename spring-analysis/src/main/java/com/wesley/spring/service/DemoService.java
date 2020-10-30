package com.wesley.spring.service;

import org.springframework.stereotype.Service;

/**
 * DemoService
 *
 * @author WangPanYong
 * @since 2020/10/22 16:02
 */
@Service
public class DemoService {

    public void hello(String str) {
        System.out.println(" ====> hello:"+ str);
    }
}

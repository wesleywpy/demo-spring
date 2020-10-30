package com.wesley.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Staff
 *
 * @author WangPanYong
 * @since 2020/10/30 14:15
 */
@Component
//@Scope("prototype")
public class Staff {
//    @Autowired
    private Company company;

    @Autowired
    public Staff(Company company) {
        this.company = company;
    }

}

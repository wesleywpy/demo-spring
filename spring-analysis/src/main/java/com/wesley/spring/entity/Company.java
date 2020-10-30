package com.wesley.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Company
 *
 * @author WangPanYong
 * @since 2020/10/30 14:15
 */
@Component
//@Scope("prototype")
public class Company {

//    @Autowired
    private Staff staff;

    @Autowired
    public Company(Staff staff) {
        this.staff = staff;
    }

}

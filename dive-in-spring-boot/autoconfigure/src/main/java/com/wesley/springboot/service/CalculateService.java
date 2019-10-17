package com.wesley.springboot.service;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/16
 */
public interface CalculateService {

    /**
     * 从多个整数 sum 求和
     * @param values 多个整数
     * @return sum 累加值
     */
    Integer sum(Integer... values);
}

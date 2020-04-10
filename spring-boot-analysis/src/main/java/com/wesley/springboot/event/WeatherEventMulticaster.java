package com.wesley.springboot.event;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/04/10
 */
public class WeatherEventMulticaster extends AbstractEventMulticaster{

    @Override
    protected void doStart() {
        System.out.println(" 开始广播天气事件 ");
    }

    @Override
    protected void doEnd() {
        System.out.println(" 结束广播天气事件 ");
    }

}

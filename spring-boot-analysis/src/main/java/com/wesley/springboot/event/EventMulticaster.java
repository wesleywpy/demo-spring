package com.wesley.springboot.event;

/**
 * <p>
 *  事件广播器
 * </p>
 *
 * @author Created by Yani on 2020/04/10
 */
public interface EventMulticaster {
    /**
     * 广播事件
     * @param event
     */
    void multicastEvent(WeatherEvent event);

    /**
     * 添加监听器
     * @param weatherListener
     */
    void addListener(WeatherListener weatherListener);

    /**
     * 移除监听器
     * @param weatherListener
     */
    void removeListener(WeatherListener weatherListener);
}

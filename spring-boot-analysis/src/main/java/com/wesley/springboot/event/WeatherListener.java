package com.wesley.springboot.event;

/**
 * <p>
 *  天气监听器
 * </p>
 *
 * @author Created by Yani on 2020/04/10
 */
public interface WeatherListener {

    void onWeatherEvent(WeatherEvent event);
}

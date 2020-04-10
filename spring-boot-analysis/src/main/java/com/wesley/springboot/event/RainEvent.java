package com.wesley.springboot.event;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/04/10
 */
public class RainEvent extends WeatherEvent {
    @Override
    public String getWeather() {
        return "rain";
    }
}

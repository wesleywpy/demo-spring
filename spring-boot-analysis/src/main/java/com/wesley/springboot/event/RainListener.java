package com.wesley.springboot.event;

import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/04/10
 */
@Component
public class RainListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof RainEvent) {
            System.out.println(" hello " + event.getWeather());
        }
    }
}

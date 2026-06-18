package com.vhugo.patterns.structural.adapter.apiversion;

public class WeatherApiV2Adapter implements WeatherApiV2 {
    private final LegacyWeatherEngine engine;

    public WeatherApiV2Adapter(LegacyWeatherEngine engine) {
        this.engine = engine;
    }

    @Override
    public void report(String city, double celsius) {
        int fahrenheit = (int) Math.round(celsius * 9 / 5 + 32);
        engine.publish(city, fahrenheit);
    }
}

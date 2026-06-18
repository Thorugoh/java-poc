package com.vhugo.patterns.structural.adapter.apiversion;

public class ApiVersionDemo {
    static void main() {
        LegacyWeatherEngine engine = new LegacyWeatherEngine();
        WeatherApiV2 api = new WeatherApiV2Adapter(engine);

        api.report("New York", 25.0);
        api.report("Sao Paulo", 30.0);
    }
}

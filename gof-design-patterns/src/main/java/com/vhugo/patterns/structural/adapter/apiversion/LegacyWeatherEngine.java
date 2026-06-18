package com.vhugo.patterns.structural.adapter.apiversion;

public class LegacyWeatherEngine {
    public void publish(String location, int fahrenheit) {
        System.out.println("Legacy engine published " + fahrenheit + "F for " + location);
    }
}

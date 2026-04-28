package com.vhugo.patterns.factory.model;

public class NormalFormatter implements  Formatter {
    @Override
    public String formatter(String message) {
        return message;
    }
}

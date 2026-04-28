package com.vhugo.patterns.factory.model;

public class NormalFormatter implements  Formatter {
    @Override
    public String format(String message) {
        return message;
    }
}

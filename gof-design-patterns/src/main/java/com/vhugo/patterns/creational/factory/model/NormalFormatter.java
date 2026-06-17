package com.vhugo.patterns.creational.factory.model;

public class NormalFormatter implements  Formatter {
    @Override
    public String format(String message) {
        return message;
    }
}

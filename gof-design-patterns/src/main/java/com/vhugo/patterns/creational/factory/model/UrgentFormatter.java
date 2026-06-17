package com.vhugo.patterns.creational.factory.model;

public class UrgentFormatter implements Formatter{

    @Override
    public String format(String message) {
        return "URGENT: " + message.toUpperCase() + "!!!";
    }
}

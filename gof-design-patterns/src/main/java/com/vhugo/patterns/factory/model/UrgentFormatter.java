package com.vhugo.patterns.factory.model;

public class UrgentFormatter implements Formatter{

    @Override
    public String format(String message) {
        return "URGENT: " + message.toUpperCase() + "!!!";
    }
}

package com.vhugo.patterns.structural.adapter;

public interface PaymentProcessor {
    void pay(String currency, double amount);
}

package com.vhugo.patterns.structural.adapter;

public class LegacyPaymentAdapter implements PaymentProcessor {
    private final LegacyPaymentGateway gateway;

    public LegacyPaymentAdapter(LegacyPaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(String currency, double amount) {
        long amountInCents = Math.round(amount * 100);
        gateway.sendPayment(amountInCents, currency);
    }
}

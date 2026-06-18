package com.vhugo.patterns.structural.adapter;

public class LegacyPaymentGateway {
    public void sendPayment(long amountInCents, String currencyCode) {
        System.out.println("Legacy gateway charged " + amountInCents + " cents in " + currencyCode);
    }
}

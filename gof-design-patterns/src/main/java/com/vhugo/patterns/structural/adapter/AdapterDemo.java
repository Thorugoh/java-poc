package com.vhugo.patterns.structural.adapter;

public class AdapterDemo {
    static void main() {
        LegacyPaymentGateway gateway = new LegacyPaymentGateway();
        PaymentProcessor processor = new LegacyPaymentAdapter(gateway);

        processor.pay("USD", 19.99);
        processor.pay("BRL", 5.00);
    }
}

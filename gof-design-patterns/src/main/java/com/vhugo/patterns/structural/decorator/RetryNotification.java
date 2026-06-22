package com.vhugo.patterns.structural.decorator;

public class RetryNotification extends NotificationDecorator {
    private final int attempts;

    public RetryNotification(Notification wrapped, int attempts) {
        super(wrapped);
        this.attempts = attempts;
    }

    @Override
    public void send(String recipient, String message) {
        for (int i = 1; i <= attempts; i++) {
            System.out.println("Retry: attempt " + i);
            super.send(recipient, message);
        }
    }
}

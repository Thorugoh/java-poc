package com.vhugo.patterns.structural.decorator;

public class LoggingNotification extends NotificationDecorator {
    public LoggingNotification(Notification wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String recipient, String message) {
        System.out.println("Log: sending to " + recipient);
        super.send(recipient, message);
        System.out.println("Log: sent to " + recipient);
    }
}

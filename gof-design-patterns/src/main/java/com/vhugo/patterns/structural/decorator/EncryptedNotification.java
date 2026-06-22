package com.vhugo.patterns.structural.decorator;

public class EncryptedNotification extends NotificationDecorator {
    public EncryptedNotification(Notification wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String recipient, String message) {
        super.send(recipient, "[encrypted] " + message);
    }
}

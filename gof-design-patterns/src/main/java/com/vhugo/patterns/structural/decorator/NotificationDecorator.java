package com.vhugo.patterns.structural.decorator;

public abstract class NotificationDecorator implements Notification {
    protected final Notification wrapped;

    protected NotificationDecorator(Notification wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send(String recipient, String message) {
        wrapped.send(recipient, message);
    }
}

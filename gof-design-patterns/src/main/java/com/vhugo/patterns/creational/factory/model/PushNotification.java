package com.vhugo.patterns.creational.factory.model;

public class PushNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("PUSH to: "+ recipient + " | " + message);
    }
}

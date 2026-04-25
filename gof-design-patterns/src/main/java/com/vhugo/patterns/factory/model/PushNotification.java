package com.vhugo.patterns.factory.model;

public class PushNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("PUSH to: "+ recipient + " | " + message);
    }
}

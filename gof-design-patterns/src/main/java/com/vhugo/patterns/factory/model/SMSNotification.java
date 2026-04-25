package com.vhugo.patterns.factory.model;

public class SMSNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sms to: "+ recipient + " | " + message);
    }
}

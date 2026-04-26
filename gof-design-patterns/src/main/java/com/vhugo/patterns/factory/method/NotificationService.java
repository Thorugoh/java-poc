package com.vhugo.patterns.factory.method;

import com.vhugo.patterns.factory.model.Notification;

public abstract class NotificationService {

    protected abstract Notification createNotification();

    public void notify(String dest, String message) {
        Notification notification = createNotification();
        System.out.println("Preparing...");
        notification.send(dest, message);
        System.out.println("notification sent.");
    }

}

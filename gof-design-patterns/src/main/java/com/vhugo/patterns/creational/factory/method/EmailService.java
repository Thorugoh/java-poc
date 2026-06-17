package com.vhugo.patterns.creational.factory.method;

import com.vhugo.patterns.creational.factory.model.EmailNotification;
import com.vhugo.patterns.creational.factory.model.Notification;

public class EmailService extends NotificationService {

    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

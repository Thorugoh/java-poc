package com.vhugo.patterns.factory.method;

import com.vhugo.patterns.factory.model.EmailNotification;
import com.vhugo.patterns.factory.model.Notification;

public class EmailService extends NotificationService {

    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

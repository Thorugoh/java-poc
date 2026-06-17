package com.vhugo.patterns.creational.factory.method;

import com.vhugo.patterns.creational.factory.model.Notification;
import com.vhugo.patterns.creational.factory.model.SMSNotification;

public class SmsService extends NotificationService {

    @Override
    protected Notification createNotification() {
        return new SMSNotification();
    }
}

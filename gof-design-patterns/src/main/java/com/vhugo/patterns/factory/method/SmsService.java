package com.vhugo.patterns.factory.method;

import com.vhugo.patterns.factory.model.Notification;
import com.vhugo.patterns.factory.model.SMSNotification;

public class SmsService extends NotificationService {

    @Override
    protected Notification createNotification() {
        return new SMSNotification();
    }
}

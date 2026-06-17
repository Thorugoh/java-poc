package com.vhugo.patterns.creational.factory.method;

import com.vhugo.patterns.creational.factory.model.Notification;
import com.vhugo.patterns.creational.factory.model.PushNotification;

public class PushService extends NotificationService {

    @Override
    protected Notification createNotification(){
        return new PushNotification();
    }
}

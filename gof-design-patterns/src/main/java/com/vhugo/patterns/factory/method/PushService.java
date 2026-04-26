package com.vhugo.patterns.factory.method;

import com.vhugo.patterns.factory.model.Notification;
import com.vhugo.patterns.factory.model.PushNotification;

public class PushService extends NotificationService {

    @Override
    protected Notification createNotification(){
        return new PushNotification();
    }
}

package com.vhugo.patterns.factory.abstact;

import com.vhugo.patterns.factory.model.Formatter;
import com.vhugo.patterns.factory.model.Notification;
import com.vhugo.patterns.factory.model.PushNotification;
import com.vhugo.patterns.factory.model.UrgentFormatter;

public class UrgentFactory implements NotificationAbstractFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }

    @Override
    public Formatter createFormatter() {
        return new UrgentFormatter();
    }
}

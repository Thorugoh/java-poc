package com.vhugo.patterns.creational.factory.abstact;

import com.vhugo.patterns.creational.factory.model.Formatter;
import com.vhugo.patterns.creational.factory.model.Notification;
import com.vhugo.patterns.creational.factory.model.PushNotification;
import com.vhugo.patterns.creational.factory.model.UrgentFormatter;

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

package com.vhugo.patterns.creational.factory.abstact;

import com.vhugo.patterns.creational.factory.model.EmailNotification;
import com.vhugo.patterns.creational.factory.model.Formatter;
import com.vhugo.patterns.creational.factory.model.NormalFormatter;
import com.vhugo.patterns.creational.factory.model.Notification;

public class NormalFactory implements NotificationAbstractFactory {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }

    @Override
    public Formatter createFormatter() {
        return new NormalFormatter();
    }
}

package com.vhugo.patterns.factory.abstact;

import com.vhugo.patterns.factory.model.EmailNotification;
import com.vhugo.patterns.factory.model.Formatter;
import com.vhugo.patterns.factory.model.NormalFormatter;
import com.vhugo.patterns.factory.model.Notification;

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

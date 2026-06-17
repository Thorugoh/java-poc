package com.vhugo.patterns.creational.factory.abstact;

import com.vhugo.patterns.creational.factory.model.Formatter;
import com.vhugo.patterns.creational.factory.model.Notification;

public interface NotificationAbstractFactory {
    Notification createNotification();
    Formatter createFormatter();
}

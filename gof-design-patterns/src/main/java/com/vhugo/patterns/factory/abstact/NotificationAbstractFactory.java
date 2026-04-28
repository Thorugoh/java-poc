package com.vhugo.patterns.factory.abstact;

import com.vhugo.patterns.factory.model.Formatter;
import com.vhugo.patterns.factory.model.Notification;

public interface NotificationAbstractFactory {
    Notification createNotification();
    Formatter createFormatter();
}

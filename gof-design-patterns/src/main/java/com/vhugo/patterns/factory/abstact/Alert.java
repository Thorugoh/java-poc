package com.vhugo.patterns.factory.abstact;

import com.vhugo.patterns.factory.model.Formatter;
import com.vhugo.patterns.factory.model.Notification;

public class Alert {
    private final Notification notification;
    private final Formatter formatter;

    public Alert(NotificationAbstractFactory factory) {
        this.notification = factory.createNotification();
        this.formatter = factory.createFormatter();
    }

    public void trig(String dest, String message) {
        String formattedData = formatter.format(message);
        notification.send(dest, message);
    }
}

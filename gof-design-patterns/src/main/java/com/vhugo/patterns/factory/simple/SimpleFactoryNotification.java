package com.vhugo.patterns.factory.simple;

import com.vhugo.patterns.factory.model.EmailNotification;
import com.vhugo.patterns.factory.model.Notification;
import com.vhugo.patterns.factory.model.PushNotification;
import com.vhugo.patterns.factory.model.SMSNotification;

import java.util.Optional;

public class SimpleFactoryNotification {
    public static Optional<Notification> create(String type) {
        return Optional.ofNullable(
            switch (type.toLowerCase()) {
                case "email" -> new EmailNotification();
                case "sms" -> new SMSNotification();
                case "push" -> new PushNotification();
                default -> null;
            }
        );
    }
}

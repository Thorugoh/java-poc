package com.vhugo.patterns.factory.demo;

import com.vhugo.patterns.factory.method.EmailService;
import com.vhugo.patterns.factory.method.NotificationService;
import com.vhugo.patterns.factory.model.Notification;
import com.vhugo.patterns.factory.simple.SimpleFactoryNotification;

import java.util.Optional;

public class FactoryPatternDemo {
    static void main() {
        // simple factory demo

        var n1 = SimpleFactoryNotification.create("sms");
        n1.ifPresent(n -> n.send("+5512345678", "Hi Sms"));

        SimpleFactoryNotification.create("fax").ifPresentOrElse(
                n -> n.send("dest", "msg"),
                () -> System.out.println("Unsupported type")
        );


        // factory method
        NotificationService emailService = new EmailService();
        emailService.notify("email@email.com", "A new email");

        NotificationService smsService = new EmailService();
        emailService.notify("+55123456789", "A new Sms");
    }
}

package com.vhugo.patterns.factory.demo;

import com.vhugo.patterns.factory.abstact.Alert;
import com.vhugo.patterns.factory.abstact.NormalFactory;
import com.vhugo.patterns.factory.abstact.UrgentFactory;
import com.vhugo.patterns.factory.method.EmailService;
import com.vhugo.patterns.factory.method.NotificationService;
import com.vhugo.patterns.factory.method.SmsService;
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

        NotificationService smsService = new SmsService();
        smsService.notify("+55123456789", "A new Sms");


        // Abstract factory
        Alert alert = new Alert(new NormalFactory());
        alert.trig("someone", "some message");

        Alert urgentAlert = new Alert(new UrgentFactory());
        urgentAlert.trig("someone", "some other message");
    }
}

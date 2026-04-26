package com.vhugo.patterns.factory.demo;

import com.vhugo.patterns.factory.model.Notification;
import com.vhugo.patterns.factory.simple.SimpleFactoryNotification;

import java.util.Optional;

public class FactoryPatternDemo {
    // simple factory demo
    static void main() {
        var n1 = SimpleFactoryNotification.create("sms");
        n1.ifPresent(n -> n.send("+5512345678", "Hi Sms"));

        SimpleFactoryNotification.create("fax").ifPresentOrElse(
                n -> n.send("dest", "msg"),
                () -> System.out.println("Unsupported type")
        );
    }
}

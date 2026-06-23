package com.vhugo.patterns.structural.decorator;

public class DecoratorDemo {
    static void main() {
        Notification email = new EmailNotification();

        Notification decorated = new RetryNotification(
                new LoggingNotification(
                        new EncryptedNotification(email)), 2);

        decorated.send("alice@example.com", "Your order has shipped");
    }
}

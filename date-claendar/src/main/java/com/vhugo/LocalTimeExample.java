package com.vhugo;

import java.time.LocalTime;

public class LocalTimeExample {
     static void main() {

        LocalTime now = LocalTime.now();
        LocalTime specificTime = LocalTime.of(14, 30);           // 14:30:00
        LocalTime withSeconds = LocalTime.of(14, 30, 45);        // 14:30:45
        LocalTime withNanos = LocalTime.of(14, 30, 45, 500000000); // 14:30:45.5

        System.out.println("Now: " + now);
        System.out.println("Specific time: " + specificTime);
        System.out.println("With seconds: " + withSeconds);
        System.out.println("With nanos: " + withNanos);

        System.out.println("Start of day: " + LocalTime.MIN);      // 00:00
        System.out.println("End of day: " + LocalTime.MAX);        // 23:59:59.999999999
        System.out.println("Midnight: " + LocalTime.MIDNIGHT);     // 00:00
        System.out.println("Noon: " + LocalTime.NOON);             // 12:00

        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());
        System.out.println("Second: " + now.getSecond());
        System.out.println("Nano: " + now.getNano());

        LocalTime openTime = LocalTime.of(9, 0);
        LocalTime closeTime = LocalTime.of(18, 0);
        boolean isOpen = !now.isBefore(openTime) && now.isBefore(closeTime);
        System.out.println("Is business time: " + isOpen);
    }
}
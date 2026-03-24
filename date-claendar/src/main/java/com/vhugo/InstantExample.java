package com.vhugo;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

class InstantExample {
    static void main(String[] args) {

        Instant now = Instant.now();
        System.out.println("Now (UTC): " + now); // 2026-03-24T19:34:39.123456789Z

        // Creating from epoch (seconds since 1970-01-01T00:00:00Z)
        Instant fromEpoch = Instant.ofEpochSecond(0);
        Instant fromMilli = Instant.ofEpochMilli(1_000_000_000_000L);
        System.out.println("Epoch start: " + fromEpoch);  // 1970-01-01T00:00:00Z
        System.out.println("From millis: " + fromMilli);  // 2001-09-09T01:46:40Z

        System.out.println("Epoch seconds: " + now.getEpochSecond());
        System.out.println("Epoch millis:  " + now.toEpochMilli());
        System.out.println("Nano adjust:   " + now.getNano());

        Instant oneHourLater = now.plus(1, ChronoUnit.HOURS);
        Instant tenMinutesAgo = now.minus(10, ChronoUnit.MINUTES);
        System.out.println("One hour later:    " + oneHourLater);
        System.out.println("Ten minutes ago:   " + tenMinutesAgo);

        // Comparing instants
        System.out.println("now is before oneHourLater: " + now.isBefore(oneHourLater));
        System.out.println("now is after tenMinutesAgo: " + now.isAfter(tenMinutesAgo));

        // Typical use case: measuring elapsed time
        Instant start = Instant.now();
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) sum += i;
        Instant end = Instant.now();
        long elapsedMillis = end.toEpochMilli() - start.toEpochMilli();
        System.out.println("Sum: " + sum);
        System.out.println("Elapsed: " + elapsedMillis + "ms");
    }
}
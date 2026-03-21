package com.vhugo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeExample {
     static void main() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime specific = LocalDateTime.of(2026, Month.MARCH, 15, 14, 30, 0);
        LocalDateTime fromParts = LocalDateTime.of(
                LocalDate.of(2026, 3, 15),
                LocalTime.of(14, 30, 0)
        );

        System.out.println("Now: " + now);
        System.out.println("Specific: " + specific);
        System.out.println("From parts: " + fromParts);

        LocalDate datePart = now.toLocalDate();
        LocalTime timePart = now.toLocalTime();
        System.out.println("Date part: " + datePart);
        System.out.println("Time part: " + timePart);

        LocalDateTime sameTimeNextYear = now.withYear(now.getYear() + 1);
        LocalDateTime atNoon = now.withHour(12).withMinute(0).withSecond(0).withNano(0);
        System.out.println("Same time next year: " + sameTimeNextYear);
        System.out.println("Today at noon: " + atNoon);

        LocalDateTime meetingTime = LocalDateTime.of(2026, Month.DECEMBER, 31, 9, 0);
        if (meetingTime.isAfter(now)) {
            System.out.println("Meeting is upcoming: " + meetingTime);
        } else {
            System.out.println("Meeting already passed: " + meetingTime);
        }
    }
}
package com.vhugo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormatterExample {
     static void main() {
        LocalDate date = LocalDate.of(2026, 3, 30);
        LocalTime time = LocalTime.of(14, 30, 45);
        LocalDateTime dateTime = LocalDateTime.of(2026, 3, 30, 14, 30, 45);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));         // 2026-03-30
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));         // 14:30:45
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2024-03-30T14:30:45

        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));         // 20260330          // Fri, 15 Mar 2024 14:30:45 GMT
    }
}

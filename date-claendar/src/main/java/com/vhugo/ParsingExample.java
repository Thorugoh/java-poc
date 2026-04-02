package com.vhugo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class ParsingExample {
    public static void main(String[] args) {

        DateTimeFormatter brazilianDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("02/04/2026", brazilianDate);
        System.out.println("Parsed date: " + date); // 2026-04-02

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse("14:30:45", timeFormatter);
        System.out.println("Parsed time: " + time); // 14:30:45

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("02/05/2026 14:30:45", dateTimeFormatter);
        System.out.println("Parsed datetime: " + dateTime); // 2026-04-02T14:30:45

        LocalDate isoDate = LocalDate.parse("2026-04-02");
        LocalDateTime isoDateTime = LocalDateTime.parse("2026-04-02T14:30:45");
        System.out.println("ISO date: " + isoDate);
        System.out.println("ISO datetime: " + isoDateTime);

        DateTimeFormatter englishMonthFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
        LocalDate englishDate = LocalDate.parse("April 02, 2026", englishMonthFormatter);
        System.out.println("Parsed from English: " + englishDate); // 2026-04-02

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] inputs = { "10/04/2026", "invalid", "32/13/2026", "01/01/2026" };

        for (String input : inputs) {
            try {
                LocalDate parsed = LocalDate.parse(input, formatter);
                System.out.println("Valid: " + input + " -> " + parsed);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid: " + input + " -> " + e.getMessage());
            }
        }
    }
}

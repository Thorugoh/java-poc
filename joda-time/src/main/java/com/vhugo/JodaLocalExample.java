package com.vhugo;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaLocalExample {
    static void main() {
        LocalDate today = LocalDate.now();
        LocalDate specificDate = new LocalDate(2026, 4, 15);

        System.out.println("Today: " + today);
        System.out.println("Specific date: " + specificDate);
        System.out.println("Year: " + specificDate.getYear());
        System.out.println("Month: " + specificDate.getMonthOfYear());
        System.out.println("Day: " + specificDate.getDayOfMonth());

        LocalTime now  = LocalTime.now();
        LocalTime specificTime = new LocalTime(14, 30, 45);

        System.out.println("Now: " + now);
        System.out.println("Specific time: " + specificTime);
        System.out.println("Hour: " + specificTime.getHourOfDay());
        System.out.println("Minute: " + specificTime.getMinuteOfHour());
        System.out.println("Second: " + specificTime.getSecondOfMinute());

        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime specificDT = new LocalDateTime(2026, 3, 15, 14, 30, 0);

        System.out.println("Now: " + nowDateTime);
        System.out.println("Specific: " + specificDT);

        LocalDate datePart = specificDT.toLocalDate();
        LocalTime timePart = specificDT.toLocalTime();
        System.out.println("Date part: " + datePart);
        System.out.println("Time part: " + timePart);

        LocalDate nextWeek  = today.plusWeeks(1);
        LocalDate lastMonth = today.minusMonths(1);
        LocalTime inOneHour = now.plusHours(1);

        System.out.println("Next week: " + nextWeek);
        System.out.println("Last month: " + lastMonth);
        System.out.println("In one hour: " + inOneHour);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        System.out.println("Formatted: " + today.toString(formatter));

        LocalDate parsed = LocalDate.parse("10/04/2026", formatter);
        System.out.println("Parsed: " + parsed);
    }
}
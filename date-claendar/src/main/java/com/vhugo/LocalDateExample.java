package com.vhugo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateExample {
    static void main() {
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2026, 3, 15);
        LocalDate fromMonth = LocalDate.of(2026, Month.MARCH, 15);

        System.out.println("Today: " + today);
        System.out.println("Specific date: " + specificDate);
        System.out.println("From month enum: " + fromMonth);

        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());           // MARCH
        System.out.println("Month value: " + today.getMonthValue()); // 3
        System.out.println("Day of month: " + today.getDayOfMonth());
        System.out.println("Day of week: " + today.getDayOfWeek()); // MONDAY
        System.out.println("Day of year: " + today.getDayOfYear());
        System.out.println("Is leap year: " + today.isLeapYear());
        System.out.println("Length of month: " + today.lengthOfMonth()); // 31

        // Checking day of week
        boolean isWeekend = today.getDayOfWeek() == DayOfWeek.SATURDAY
                || today.getDayOfWeek() == DayOfWeek.SUNDAY;
        System.out.println("Is weekend: " + isWeekend);
    }
}
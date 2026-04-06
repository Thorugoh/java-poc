package com.vhugo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class PlusMinusExample {
    static void main() {
        LocalDate date = LocalDate.of(2026, Month.APRIL, 6);

        LocalDate plusDays    = date.plusDays(10);
        LocalDate plusWeeks   = date.plusWeeks(2);
        LocalDate plusMonths  = date.plusMonths(3);
        LocalDate plusYears   = date.plusYears(1);

        System.out.println("Original:  " + date);
        System.out.println("+10 days:  " + plusDays);
        System.out.println("+2 weeks:  " + plusWeeks);
        System.out.println("+3 months: " + plusMonths);
        System.out.println("+1 year:   " + plusYears);

        LocalDate minusDays   = date.minusDays(10);
        LocalDate minusWeeks  = date.minusWeeks(2);
        LocalDate minusMonths = date.minusMonths(3);
        LocalDate minusYears  = date.minusYears(1);

        System.out.println("Original:  " + date);
        System.out.println("-10 days:  " + minusDays);
        System.out.println("-2 weeks:  " + minusWeeks);
        System.out.println("-3 months: " + minusMonths);
        System.out.println("-1 year:   " + minusYears);

        LocalDate plusWithUnit  = date.plus(45, ChronoUnit.DAYS);
        LocalDate minusWithUnit = date.minus(6, ChronoUnit.MONTHS);

        System.out.println("+ 45 days (ChronoUnit): "+ plusWithUnit);
        System.out.println("-6 months: " + minusWithUnit);

        LocalTime time = LocalTime.of(14, 30, 0);
        LocalTime plusHours   = time.plusHours(3);
        LocalTime plusMinutes = time.plusMinutes(45);
        LocalTime minusHours  = time.minusHours(2);

        System.out.println("Original time: " + time);
        System.out.println("+3 hours:      " + plusHours);
        System.out.println("+45 minutes:   " + plusMinutes);
        System.out.println("-2 hours:      " + minusHours);


        LocalDateTime dateTime = LocalDateTime.of(2026, Month.APRIL, 1, 9, 3, 0);
        LocalDateTime plusAll  = dateTime.plusYears(1).plusMonths(2).plusDays(10).plusHours(5);

        System.out.println("Original datetime: " + dateTime);
        System.out.println("After chaining:    " + plusAll);

        System.out.println("Original unchanged: " + dateTime);
    }
}

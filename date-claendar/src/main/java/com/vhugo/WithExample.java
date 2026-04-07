package com.vhugo;

import java.time.LocalDate;
import java.time.Month;

public class WithExample {
    static void main() {
        LocalDate date = LocalDate.of(2027, Month.APRIL, 7);

        LocalDate withYear  = date.withYear(2025);
        LocalDate withMonth = date.withMonth(12);
        LocalDate withDay   = date.withDayOfMonth(1);

        System.out.println("Original:      " + date);
        System.out.println("With year:     " + withYear);
        System.out.println("With month:    " + withMonth);
        System.out.println("With day:      " + withDay);

        LocalDate firstDayOfMonth = date.withDayOfMonth(1);
        LocalDate lastDayOfMonth  = date.withDayOfMonth(date.lengthOfMonth());

        System.out.println("First day of month: " + firstDayOfMonth);
        System.out.println("Last day of month:  " + lastDayOfMonth);


        LocalDate firstDayOfYear = date.withDayOfYear(1);
        LocalDate lastDayOfYear  = date.withDayOfYear(date.lengthOfYear());

        System.out.println("First day of year:  " + firstDayOfYear);
        System.out.println("Last day of year:   " + lastDayOfYear);
    }
}

package com.vhugo;

import java.time.LocalDate;
import java.util.Date;

public class YearsExample {
    static void main() {

        @SuppressWarnings("deprecation")
        Date wrongDate = new Date(2026, 2, 15);
        System.out.println("Date (wrong  year): " + wrongDate);

        @SuppressWarnings("deprecation")
        Date correctDate = new Date(124, 2, 15); // 2024 - 1900 = 124
        System.out.println("Date (year 'correct'): " + correctDate);

        // LocalDate
        LocalDate data = LocalDate.of(2026, 3, 15);
        System.out.println("LocalDate: " + data);
    }
}

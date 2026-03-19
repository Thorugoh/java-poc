package com.vhugo;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    static void main() {

        // Old Calendar and Date
        Calendar cal = Calendar.getInstance();
        // 0 indexed month
        cal.set(2024, Calendar.MARCH, 15);
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date result = cal.getTime();

        System.out.println(result);
        // Sun Apr 14 21:08:11 GMT-03:00 2024 // Time together

        // New date time api
        LocalDate resultLocalDate = LocalDate.of(2024, 3, 15).plusDays(30);
    }
}

package com.vhugo;


import java.util.Calendar;
import java.util.Date;

public class Main {
    static void main() {
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.MARCH, 15);
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date result = cal.getTime();

        System.out.println(result);
        // Sun Apr 14 21:08:11 GMT-03:00 2024 // Time together
    }
}
